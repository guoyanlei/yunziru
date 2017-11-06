package com.yunziru.movie.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.yunziru.common.service.CommonService;
import com.yunziru.movie.dao.MovieDao;
import com.yunziru.movie.dao.MovieDaoImpl;
import com.yunziru.movie.dto.MovieDetailDTO;
import com.yunziru.movie.dto.MovieSimpleDTO;
import com.yunziru.movie.entity.Movie;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    private MovieDaoImpl movieDaoImpl;

    @Autowired
    public void setMovieDao(MovieDao movieDao){
        super.setCommonDao(movieDao);
    }

    public List<MovieSimpleDTO> getMovieList() {
        return movieDaoImpl.getMovielist();
    }

    public List<MovieSimpleDTO> getSimpleMovieList() {
        return movieDaoImpl.getMovieEntity();
    }

    public MovieDetailDTO getMovieDetailInfo(Long movieId) {

        Movie movie = super.find(movieId);

        MovieDetailDTO detailDTO = new MovieDetailDTO();
        detailDTO.setId(movie.getId());
        detailDTO.setTitle(movie.getTitle());
        detailDTO.setPoster(movie.getPoster());
        detailDTO.setSummary(movie.getSummary());
        List<String> images = JSON.parseArray(movie.getScreenshot(), String.class);
        detailDTO.setImages(images);

        if (StringUtils.isNoneEmpty(movie.getBaiduLink())) {
            detailDTO.setBaiduLink(movie.getBaiduLink());
            detailDTO.setBaiduPwd(movie.getBaiduPwd());
        }
        if (StringUtils.isNoneEmpty(movie.getEd2kLink())) {
            Map<String, String> ed2kLinks = JSONObject.parseObject(movie.getEd2kLink(), new TypeReference<Map<String, String>>(){});
            detailDTO.setEd2kLinks(ed2kLinks);
        }
        return detailDTO;
    }
}