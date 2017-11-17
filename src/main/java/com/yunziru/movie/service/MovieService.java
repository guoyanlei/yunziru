package com.yunziru.movie.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import com.yunziru.common.service.CommonService;
import com.yunziru.common.util.PageUtil;
import com.yunziru.movie.dao.MovieDao;
import com.yunziru.movie.dao.impl.MovieDaoImpl;
import com.yunziru.movie.dto.MovieDetailDTO;
import com.yunziru.movie.dto.MovieSimpleDTO;
import com.yunziru.movie.entity.Movie;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author guoyanlei
 * @desc MovieService类 
 * @date 2017-10-30
 */
@Service
public class MovieService extends CommonService<Movie, Long> {

    private final static int RANDOM_COUNT = 5;
    private final static int ULIKE_COUNT = 4;

    @Autowired
    private MovieDao movieDao;

    @Autowired
    private MovieDaoImpl movieDaoImpl;

    @Autowired
    public void setMovieDao(MovieDao movieDao){
        super.setCommonDao(movieDao);
    }

    /**
     * 对电影点赞
     */
    public boolean updatePriseCount(Long id) {
        return movieDao.updatePriseCountById(id)> 0;
    }

    /**
     * 浏览电影
     */
    public boolean updateHotCount(Long id) {
        return movieDao.updateHotCountById(id)> 0;
    }

    /**
     * 获取资源总数
     */
    public Long getTotalCount() {
        return movieDao.count();
    }

    /**
     * 获取电影概览信息
     * @param page 当前页数
     * @param size 每页大小
     */
    public List<MovieSimpleDTO> getIndexMovieList(int page, int size) {
        return movieDaoImpl.getMovielist(PageUtil.getOffset(page, size), size);
    }

    /**
     * 获取热门电影概览信息
     * @param page 当前页数
     * @param size 每页大小
     */
    public List<MovieSimpleDTO> getHotMovieList(int page, int size) {
        return movieDaoImpl.getHotMovielist(PageUtil.getOffset(page, size), size);
    }

    /**
     * 获取电影资源详情
     * @param movieId 电影id
     * @return 资源详情
     */
    public MovieDetailDTO getMovieDetailInfo(Long movieId) {

        Movie movie = super.find(movieId);

        MovieDetailDTO detailDTO = new MovieDetailDTO();
        detailDTO.setId(movie.getId());
        detailDTO.setTitle(movie.getTitle());
        detailDTO.setPoster(movie.getPoster());
        detailDTO.setPriseCount(movie.getPriseCount());
        detailDTO.setCreateTime(movie.getCreateTime());
        if (movie.getYear() > 0) {
            detailDTO.setYear(movie.getYear());
        }
        detailDTO.setHotCount(movie.getHotCount());
        detailDTO.setLocation(movie.getLocation());
        detailDTO.setType(movie.getType());
        detailDTO.setSummary(StringUtils.isNoneEmpty(movie.getSummary()) ? movie.getSummary().replaceAll("\n\n", "<br/>") : "");
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

    /**
     * 随机获取N个热门电影
     */
    public List<MovieSimpleDTO> getRandomHotMovie() {
        List<MovieSimpleDTO> movieSimpleDTOs = movieDaoImpl.getHotMovielist(0, 100);

        List<MovieSimpleDTO> result = Lists.newArrayList();
        Random rand = new Random();
        int size = movieSimpleDTOs.size() < RANDOM_COUNT ? movieSimpleDTOs.size() : RANDOM_COUNT;

        for (int i = 0; i< size; i++) {
            int randomNum=rand.nextInt(movieSimpleDTOs.size());
            result.add(movieSimpleDTOs.get(randomNum));
            movieSimpleDTOs.remove(randomNum);
        }
        return result;
    }

    /**
     * 随机获取N个猜你喜欢电影
     */
    public List<MovieSimpleDTO> getULikeMovie() {
        List<MovieSimpleDTO> movieSimpleDTOs = movieDaoImpl.getULikeMovielist(0, 100);

        List<MovieSimpleDTO> result = Lists.newArrayList();
        Random rand = new Random();
        int size = movieSimpleDTOs.size() < ULIKE_COUNT ? movieSimpleDTOs.size() : ULIKE_COUNT;

        for (int i = 0; i< size; i++) {
            int randomNum=rand.nextInt(movieSimpleDTOs.size());
            result.add(movieSimpleDTOs.get(randomNum));
            movieSimpleDTOs.remove(randomNum);
        }
        return result;
    }
}