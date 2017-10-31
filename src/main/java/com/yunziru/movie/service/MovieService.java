package com.yunziru.movie.service;

import com.yunziru.common.service.CommonService;
import com.yunziru.movie.dao.MovieDao;
import com.yunziru.movie.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guoyanlei
 * @desc MovieService类 
 * @date 2017-10-30
 */
@Service
public class MovieService extends CommonService<Movie, Long> {

    @Autowired
    private MovieDao movieDao;

    @Autowired
    public void setMovieDao(MovieDao movieDao){
        super.setCommonDao(movieDao);
    }


}