package com.yunziru.tag.entity;

import javax.persistence.*;

/**
 * Created by guoyanlei
 * date：2017/11/11
 * time：21:17
 * description：电影-标签关联关系
 */
@Entity
@Table(name = "yunziru_movie_tag")
public class MovieTag {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long movieId;
    private Long tagId;
    private Long createTime;

    public MovieTag(Long movieId, Long tagId, Long createTime) {
        this.movieId = movieId;
        this.tagId = tagId;
        this.createTime = createTime;
    }

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

    @Column(name = "tag_id")
    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    @Column(name = "create_time")
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MovieTag{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", tagId=" + tagId +
                ", createTime=" + createTime +
                '}';
    }
}
