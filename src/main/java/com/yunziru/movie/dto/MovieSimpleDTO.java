package com.yunziru.movie.dto;

import org.joda.time.DateTime;

/**
 * Created by guoyanlei
 * Date：2017/11/6
 * Description：
 */
public class MovieSimpleDTO {

    private Long id;
    private String title;
    private String name;
    private String poster;
    private Integer priseCount;
    private Integer hotCount;
    private Long createTime;

    public MovieSimpleDTO() {
    }

    public MovieSimpleDTO(Long id, String title, String name, String poster,Integer priseCount, Integer hotCount, Long createTime) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.poster = poster;
        this.priseCount = priseCount;
        this.hotCount = hotCount;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Integer getPriseCount() {
        return priseCount;
    }

    public void setPriseCount(Integer priseCount) {
        this.priseCount = priseCount;
    }

    public Integer getHotCount() {
        return hotCount;
    }

    public void setHotCount(Integer hotCount) {
        this.hotCount = hotCount;
    }

    public String getCreateTime() {
        return new DateTime(createTime).toString("yyyy-MM-dd");
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public static MovieSimpleDTO of(Long id, String title, String name, String poster,Integer priseCount, Integer hotCount, Long createTime) {
        return new MovieSimpleDTO(id, title, name, poster, priseCount, hotCount, createTime);
    }

    @Override
    public String toString() {
        return "MovieSimpleDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", poster='" + poster + '\'' +
                ", priseCount=" + priseCount +
                ", hotCount=" + hotCount +
                ", createTime=" + createTime +
                '}';
    }
}
