package com.yunziru.tag.service;

import com.google.common.collect.Lists;
import com.yunziru.common.dto.PageModel;
import com.yunziru.common.service.CommonService;
import com.yunziru.common.util.PageUtil;
import com.yunziru.movie.entity.Movie;
import com.yunziru.tag.dao.MovieTagDao;
import com.yunziru.tag.dao.TagDao;
import com.yunziru.tag.dao.impl.TagDaoImpl;
import com.yunziru.tag.dto.TagMovieStat;
import com.yunziru.tag.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author guoyanlei
 * @desc MovieService类 
 * @date 2017-10-30
 */
@Service
public class TagService extends CommonService<Tag, Long> {

    @Autowired
    private TagDao tagDao;

    @Autowired
    private MovieTagDao movieTagDao;

    @Autowired
    private TagDaoImpl tagDaoImpl;

    @Autowired
    public void setMovieDao(TagDao tagDao){
        super.setCommonDao(tagDao);
    }

    /**
     * 根据电影id获取其所对应的标签，即标签统计
     * @param movieId 电影id
     * @return 标签统计
     */
    public List<TagMovieStat> getMovieTagStats(Long movieId) {

        List<Movie> movieList = movieTagDao.findMovieById(movieId);
        if(movieList == null || movieList.size() <= 0){
            return Lists.newArrayList();
        }
        Set<Tag> tags = movieList.get(0).getTags();

        List<TagMovieStat> movieStats = Lists.newArrayList();
        for (Tag tag : tags) {
            List<Tag> tagList = tagDao.findTagById(tag.getId());
            if (tagList != null && tagList.size() > 0) {
                Tag movieTag = tagList.get(0);
                movieStats.add(new TagMovieStat(movieTag.getId(), movieTag.getTagName(), tagList.get(0).getMovies().size()));
            }
        }

        Collections.sort(movieStats);

        return movieStats;
    }
}