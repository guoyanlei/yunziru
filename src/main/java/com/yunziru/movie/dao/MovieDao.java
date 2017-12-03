package com.yunziru.movie.dao;

import com.yunziru.common.dao.CommonDao;
import com.yunziru.movie.entity.Movie;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by guoyanlei
 * date：2017/10/26
 * time：18:27
 * description：
 */
public interface MovieDao extends CommonDao<Movie, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update Movie m set m.priseCount = m.priseCount+1 where m.id = ?1")
    int updatePriseCountById(Long id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update Movie m set m.hotCount = m.hotCount+1 where m.id = ?1")
    int updateHotCountById(Long id);

    @Query("select m from Movie m where m.tid = ?1 ")
    List<Movie> findMovieByTid(Integer tid);
}
