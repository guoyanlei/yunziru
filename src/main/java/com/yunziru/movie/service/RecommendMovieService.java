package com.yunziru.movie.service;

import com.yunziru.common.service.CommonService;
import com.yunziru.common.util.PageUtil;
import com.yunziru.movie.dao.RecommendMovieDao;
import com.yunziru.movie.dao.impl.RecommendMovieDaoImpl;
import com.yunziru.movie.dto.MovieSimpleDTO;
import com.yunziru.movie.entity.Movie;
import com.yunziru.movie.entity.RecommendMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author guoyanlei
 * @desc MovieService类 
 * @date 2017-10-30
 */
@Service
public class RecommendMovieService extends CommonService<RecommendMovie, Long> {

    @Autowired
    private RecommendMovieDao recommendMovieDao;

    @Autowired
    private RecommendMovieDaoImpl recommendMovieDaoImpl;

    @Autowired
    private MovieService movieService;

    @Autowired
    public void setMovieDao(RecommendMovieDao recommendMovieDao){
        super.setCommonDao(recommendMovieDao);
    }

    /**
     * 获取推荐概览信息
     * @param page 当前页数
     * @param size 每页大小
     */
    public List<MovieSimpleDTO> getRCMMovielist(int page, int size) {


        List<RecommendMovie> recommendMovies = recommendMovieDaoImpl.getRCMMovielist(PageUtil.getOffset(page, size), size);

        return recommendMovies.stream().map(rcm -> {
            Movie movie = movieService.find(rcm.getMovieId());
            return MovieSimpleDTO.of(
                     movie.getId()
                    ,movie.getTitle()
                    ,movie.getName()
                    ,movie.getPoster()
                    ,movie.getPriseCount()
                    ,movie.getCreateTime()
                    );
        }).collect(Collectors.toList());
    }


}