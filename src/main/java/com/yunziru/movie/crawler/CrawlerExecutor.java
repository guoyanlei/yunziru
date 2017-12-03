package com.yunziru.movie.crawler;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.qiniu.util.StringUtils;
import com.yunziru.common.util.QiniuUtil;
import com.yunziru.movie.entity.Movie;
import com.yunziru.movie.service.MovieService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by guoyanlei
 * Date：2017/12/3
 * Description：
 */
@Service
public class CrawlerExecutor {

    private static Logger LOG = Logger.getLogger(CrawlerExecutor.class);

    public final static String MOVIE_LIST = "http://www.mxroom.com/forum-36-1.html";

    @Resource
    private MovieCrawler movieCrawler;

    @Resource
    private MovieService movieService;

    public void execute() {

        //获取要爬取的电影类别
        String movieListContent = movieCrawler.getResponseContent(MOVIE_LIST);
        Map<Integer, String> maps = movieCrawler.parseMovieList(movieListContent);

        //分别爬取
        for (Integer key : maps.keySet()) {
            System.out.println(maps.get(key));
            //LOG.info(maps.get(key));
            if (Objects.isNull(movieService.getMovieByTid(key))) {
                Movie movie = movieCrawler.parseMovie(movieCrawler.getResponseContent(maps.get(key)));
                movie.setTid(key);
                if (!StringUtils.isNullOrEmpty(movie.getPoster())) {
                    String qiniuUrl = QiniuUtil.storeMovieImage(movie.getPoster());
                    System.out.println(qiniuUrl);
                    //LOG.info(qiniuUrl);
                    movie.setPoster(qiniuUrl);
                }
                List<String> newScrenshot = Lists.newArrayList();
                List<String> screenshot = JSON.parseArray(movie.getScreenshot(), String.class);
                if (screenshot != null) {
                    for (String s : screenshot) {
                        String qiniuUrl = QiniuUtil.storeMovieImage(s);
                        System.out.println(qiniuUrl);
                        LOG.info(qiniuUrl);
                        newScrenshot.add(qiniuUrl);
                    }
                }
                movie.setScreenshot(JSON.toJSONString(newScrenshot));
                System.out.println(movie);
                movieService.save(movie);
            }
        }
    }
}
