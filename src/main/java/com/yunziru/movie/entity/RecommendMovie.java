package com.yunziru.movie.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

/**
 * Created by guoyanlei
 * date：2017/11/11
 * time：21:17
 * description：推荐电影
 */
@Entity
@Table(name = "yunziru_recommend")
public class RecommendMovie {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long movieId;
    private Long createTime;
    private Long updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "movie_id")
    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    @Column(name = "create_time")
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Column(name = "update_time")
    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "RecommendMovie{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
