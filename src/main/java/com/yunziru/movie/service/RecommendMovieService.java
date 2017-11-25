package com.yunziru.movie.service;

import com.google.common.collect.Lists;
import com.yunziru.common.service.CommonService;
import com.yunziru.common.util.PageUtil;
import com.yunziru.movie.dao.RecommendMovieDao;
import com.yunziru.movie.dao.impl.RecommendMovieDaoImpl;
import com.yunziru.movie.dto.MovieSimpleDTO;
import com.yunziru.movie.entity.Movie;
import com.yunziru.movie.entity.RecommendMovie;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
    public void setMovieDao(RecommendMovieDao recommendMovieDao) {
        super.setCommonDao(recommendMovieDao);
    }

    /**
     * 获取推荐概览信息
     *
     * @param page 当前页数
     * @param size 每页大小
     */
    public List<MovieSimpleDTO> getRCMMovielist(int page, int size) {


        List<RecommendMovie> recommendMovies = recommendMovieDaoImpl.getRCMMovielist(PageUtil.getOffset(page, size), size);

        return buildSimpleMovies(recommendMovies);
    }

    public List<MovieSimpleDTO> buildSimpleMovies(List<RecommendMovie> recommendMovies) {
        return recommendMovies.stream().map(rcm -> {
            Movie movie = movieService.find(rcm.getMovieId());
            return MovieSimpleDTO.of(
                    movie.getId()
                    , movie.getTitle()
                    , movie.getName()
                    , movie.getPoster()
                    , movie.getPriseCount()
                    , movie.getHotCount()
                    , movie.getCreateTime()
            );
        }).collect(Collectors.toList());
    }

    /**
     * 分页获取，支持搜索
     */
    public Page<MovieSimpleDTO> findAllByPage(int page, int size, String time) {

        List<Sort.Order> orders = Lists.newArrayList();
        orders.add(new Sort.Order(Sort.Direction.DESC, "id"));
        Sort sort = new Sort(orders);
        PageRequest pageRequest = new PageRequest(page - 1, size, sort);

        Page<RecommendMovie> recommendMovies = findAll((root, criteriaQuery, criteriaBuilder) -> {
            //按时间搜索
            if (StringUtils.isNoneEmpty(time)) {
                LocalDateTime dateTime = LocalDateTime.parse(time + " 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                LocalDateTime dateTimePlus = dateTime.plusDays(1L);
                long timeStamp = dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                long timeStampPlusDay = dateTimePlus.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                criteriaQuery.where(
                        criteriaBuilder.and(
                                criteriaBuilder.ge(root.get("createTime").as(Long.class), timeStamp),
                                criteriaBuilder.le(root.get("createTime").as(Long.class), timeStampPlusDay)
                        ));
            }
            return null;
        }, pageRequest);

        return new PageImpl<>(buildSimpleMovies(recommendMovies.getContent()), pageRequest, recommendMovies.getTotalElements());

    }

    /**
     * 添加推荐电影
     *
     * @param movieId 电影id
     * @return 添加结果
     */
    public boolean addRecommend(Long movieId) {
        List<RecommendMovie> movies = recommendMovieDao.findByMovieId(movieId);
        if (movies != null && movies.size() > 0) {
            return false;
        }

        RecommendMovie recommendMovie = new RecommendMovie();
        recommendMovie.setMovieId(movieId);
        long time = System.currentTimeMillis();
        recommendMovie.setCreateTime(time);
        recommendMovie.setUpdateTime(time);
        return recommendMovieDao.save(recommendMovie) != null;
    }

    /**
     * 删除推荐
     * @param movieId
     */
    public void deleteRecommend(Long movieId) {
        recommendMovieDao.deleteByMovieId(movieId);
    }
}