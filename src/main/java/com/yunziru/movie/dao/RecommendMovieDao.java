package com.yunziru.movie.dao;

import com.yunziru.common.dao.CommonDao;
import com.yunziru.movie.entity.RecommendMovie;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by guoyanlei
 * date：2017/10/26
 * time：18:27
 * description：
 */
public interface RecommendMovieDao extends CommonDao<RecommendMovie, Long> {

    @Query("select r from RecommendMovie r where r.movieId=?1 ")
    List<RecommendMovie> findByMovieId(Long movieId);

    @Modifying(clearAutomatically = true)
    @Query("delete from RecommendMovie r where r.movieId=?1 ")
    void deleteByMovieId(Long movieId);
}

