package com.yunziru.movie.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import com.yunziru.cloud.resource.service.CloudResourceService;
import com.yunziru.common.service.CommonService;
import com.yunziru.common.util.PageUtil;
import com.yunziru.meiju.service.MeiJuService;
import com.yunziru.movie.dao.MovieDao;
import com.yunziru.movie.dao.impl.MovieDaoImpl;
import com.yunziru.movie.dto.MovieDetailDTO;
import com.yunziru.movie.dto.MovieRBodyDTO;
import com.yunziru.movie.dto.MovieSimpleDTO;
import com.yunziru.movie.entity.Movie;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
    private CloudResourceService cloudResourceService;

    @Autowired
    private MeiJuService meiJuService;

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
        return movieDao.count() + cloudResourceService.getTotalCount() + meiJuService.getTotalCount();
    }

    /**
     * 根据tid获取电影
     * @param tid 爬取电影网站的id
     */
    public Movie getMovieByTid(Integer tid){
        Movie movie = null;
        List<Movie> movieList = this.movieDao.findMovieByTid(tid);
        if(movieList != null && movieList.size() > 0){
            movie = movieList.get(0);
        }
        return movie;
    }

    /**
     * 获取电影概览信息
     * @param page 当前页数
     * @param size 每页大小
     */
    public List<MovieSimpleDTO> getIndexMovieList(String keyword, int page, int size) {
        if ("".equals(keyword)) {
            return Lists.newArrayList();
        }
        return movieDaoImpl.getMovielist(keyword, PageUtil.getOffset(page, size), size);
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
        if (movie.getYear() != null && movie.getYear() > 0) {
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

    /**
     * 分页获取，支持搜索
     */
    public Page<Movie> findAllByPage(int page, int size, String time, String keyword) {


        List<Sort.Order> orders = Lists.newArrayList();
        orders.add(new Sort.Order(Sort.Direction.DESC,"id"));
        Sort sort = new Sort(orders);
        PageRequest pageRequest = new PageRequest(page-1, size, sort);

        return findAll((root, criteriaQuery, criteriaBuilder) -> {
            //按关键字搜索
            if (StringUtils.isNoneEmpty(keyword) && StringUtils.isEmpty(time)) {
                criteriaQuery.where(
                        criteriaBuilder.and(
                                criteriaBuilder.like(root.get("title").as(String.class),"%" + keyword + "%")
                        ));
            }
            //按关键字和时间搜索
            if (StringUtils.isNoneEmpty(keyword) && StringUtils.isNoneEmpty(time)) {
                LocalDateTime dateTime = LocalDateTime.parse(time + " 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                LocalDateTime dateTimePlus = dateTime.plusDays(1L);
                long timeStamp = dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                long timeStampPlusDay = dateTimePlus.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                criteriaQuery.where(
                        criteriaBuilder.and(
                                criteriaBuilder.like(root.get("title").as(String.class),"%" + keyword + "%"),
                                criteriaBuilder.le(root.get("createTime").as(Long.class), timeStampPlusDay),
                                criteriaBuilder.ge(root.get("createTime").as(Long.class), timeStamp)
                        ));
            }
            //按时间搜索
            if (StringUtils.isEmpty(keyword) && StringUtils.isNoneEmpty(time)) {
                LocalDateTime dateTime = LocalDateTime.parse(time + " 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                LocalDateTime dateTimePlus = dateTime.plusDays(1L);
                long timeStamp = dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                long timeStampPlusDay = dateTimePlus.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                criteriaQuery.where(
                        criteriaBuilder.and(
                                criteriaBuilder.le(root.get("createTime").as(Long.class), timeStampPlusDay),
                                criteriaBuilder.ge(root.get("createTime").as(Long.class), timeStamp)
                        ));
            }
            return null;
        }, pageRequest);
    }

    /**
     * 删除电影
     * @param movieId
     */
    public void deleteMovie(Long movieId) {
        movieDao.delete(movieId);
    }


    /**
     * 添加（修改）电影
     */
    public boolean addMovie(Long id, String title, String name,
                         Integer year, String location,
                         String type, String ed2kLink,
                         String baiduLink, String baiduPwd,
                         Integer tid, String summary,
                         String images) {
        Movie movie;
        if (Objects.isNull(id)) {
            movie = new Movie();
            long time = System.currentTimeMillis();
            movie.setCreateTime(time);
            movie.setUpdateTime(time);
            movie.setHotCount(0);
            movie.setPriseCount(0);
        } else {
            movie = this.find(id);
        }

        movie.setTitle(title.trim());
        movie.setName(name.trim());
        movie.setYear(year);
        movie.setLocation(location.trim());
        movie.setType(type.trim());
        movie.setBaiduLink(baiduLink.trim());
        movie.setBaiduPwd(baiduPwd.trim());
        movie.setTid(tid);
        movie.setSummary(summary);
        movie.setEd2kLink(ed2kLink);

        if (StringUtils.isNoneEmpty(images)) {
            List<String> shot = Lists.newArrayList();
            String[] imageUrls = images.split(";");
            for (int i = 0; i < imageUrls.length; i++) {
                if (i == imageUrls.length - 1) {
                    movie.setPoster(imageUrls[i]);
                } else {
                    shot.add(imageUrls[i]);
                }
            }
            movie.setScreenshot(JSON.toJSONString(shot));
        }
        return this.save(movie) != null;
    }

    public MovieRBodyDTO getMovieRBody(Long movieId) {
        Movie movie = this.find(movieId);

        MovieRBodyDTO movieRBody = new MovieRBodyDTO();
        movieRBody.setId(movie.getId());
        movieRBody.setTitle(movie.getTitle());
        movieRBody.setName(movie.getName());
        movieRBody.setYear(movie.getYear());
        movieRBody.setLocation(movie.getLocation());
        movieRBody.setType(movie.getType());
        movieRBody.setEd2kLink(movie.getEd2kLink());
        movieRBody.setBaiduLink(movie.getBaiduLink());
        movieRBody.setBaiduPwd(movie.getBaiduPwd());
        movieRBody.setTid(movie.getTid());
        movieRBody.setSummary(movie.getSummary());

        List<String> images = Lists.newArrayList();
        List<String> shot = JSON.parseArray(movie.getScreenshot(), String.class);
        images.addAll(shot);
        images.add(movie.getPoster());

        movieRBody.setImages(StringUtils.join(images, ";"));

        return movieRBody;
    }
}