package com.yunziru.movie.crawler;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.qiniu.util.StringUtils;
import com.yunziru.common.util.QiniuUtil;
import com.yunziru.movie.entity.Movie;
import com.yunziru.movie.service.MovieService;
import com.yunziru.tag.entity.MovieTag;
import com.yunziru.tag.entity.Tag;
import com.yunziru.tag.service.MovieTagService;
import com.yunziru.tag.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by guoyanlei
 * Date：2017/12/3
 * Description：
 */
@Service
public class CrawlerExecutor {

    private static final Logger LOG = LoggerFactory.getLogger(CrawlerExecutor.class);

    public final static String MOVIE_LIST = "http://www.mxroom.com/forum-36-1.html";

    @Resource
    private MovieCrawler movieCrawler;

    @Resource
    private MovieService movieService;

    @Resource
    private TagService tagService;

    @Resource
    private MovieTagService movieTagService;

    public void execute() {

        //获取所以标签
        List<Tag> tagList = tagService.getAll();

        //获取要爬取的电影类别
        String movieListContent = movieCrawler.getResponseContent(MOVIE_LIST);
        Map<Integer, String> maps = movieCrawler.parseMovieList(movieListContent);

        //分别爬取
        for (Integer key : maps.keySet()) {
            LOG.info(maps.get(key));
            if (Objects.isNull(movieService.getMovieByTid(key))) {
                Movie movie = movieCrawler.parseMovie(movieCrawler.getResponseContent(maps.get(key)));
                if (!StringUtils.isNullOrEmpty(movie.getPoster()) && !isContainChinese(movie.getPoster())) {
                    movie.setTid(key);
                    String qiniuUrl = QiniuUtil.storeMovieImage(movie.getPoster());
                    LOG.info(qiniuUrl);
                    movie.setPoster(qiniuUrl);

                    List<String> newScrenshot = Lists.newArrayList();
                    List<String> screenshot = JSON.parseArray(movie.getScreenshot(), String.class);
                    if (screenshot != null) {
                        for (String s : screenshot) {
                            if (!isContainChinese(s)) {
                                String url = QiniuUtil.storeMovieImage(s);
                                LOG.info(url);
                                newScrenshot.add(url);
                            }
                        }
                    }
                    movie.setScreenshot(JSON.toJSONString(newScrenshot));
                    movie.setHotCount(0);
                    movie.setPriseCount(0);
                    movie.setCreateTime(System.currentTimeMillis());
                    movie.setUpdateTime(System.currentTimeMillis());
                    movieService.save(movie);
                    addMovieTag(tagList, movie);
                }
            }
        }
    }

    public boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    /**
     * 添加标签
     */
    private void addMovieTag(List<Tag> tags, Movie movie) {

        List<MovieTag> movieTags = Lists.newArrayList();
        String year = String.valueOf(movie.getYear());
        String location = movie.getLocation() == null ? "" :movie.getLocation();
        String type = movie.getType() == null ? "" : movie.getType();

        for (Tag tag : tags) {
            if (year.contains(tag.getTagName())) {
                movieTags.add(new MovieTag(movie.getId(), tag.getId(), System.currentTimeMillis()));
            }
            if (location.contains(tag.getTagName())) {
                movieTags.add(new MovieTag(movie.getId(), tag.getId(), System.currentTimeMillis()));
            }
            if (type.contains(tag.getTagName())) {
                movieTags.add(new MovieTag(movie.getId(), tag.getId(), System.currentTimeMillis()));
            }
        }
        movieTags.forEach(movieTag -> movieTagService.save(movieTag));
    }
}
