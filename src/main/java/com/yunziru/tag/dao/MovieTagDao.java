package com.yunziru.tag.dao;

import com.yunziru.common.dao.CommonDao;
import com.yunziru.movie.entity.Movie;
import com.yunziru.tag.entity.MovieTag;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by guoyanlei
 * date：2017/10/26
 * time：18:27
 * description：
 */
public interface MovieTagDao extends CommonDao<MovieTag, Long> {

    @Query("SELECT m FROM Movie m JOIN m.tags t where m.id = ?1 ")
    List<Movie> findMovieById(Long id);
}
