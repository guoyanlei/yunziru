package com.yunziru.movie.dto;

/**
 * Created by guoyanlei
 * Date：2017/11/6
 * Description：
 */
public class MovieSimpleDTO {

    private Long id;
    private String title;
    private String poster;
    private Integer priseCount;
    private Long createTime;

    public MovieSimpleDTO() {
    }

    public MovieSimpleDTO(Long id, String title, String poster,Integer priseCount, Long createTime) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.priseCount = priseCount;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MovieSimpleDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", poster='" + poster + '\'' +
                ", priseCount=" + priseCount +
                ", createTime=" + createTime +
                '}';
    }
}
