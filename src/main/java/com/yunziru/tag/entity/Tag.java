package com.yunziru.tag.entity;

import com.yunziru.movie.entity.Movie;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by guoyanlei
 * date：2017/11/11
 * time：21:17
 * description：标签
 */
@Entity
@Table(name = "yunziru_tag")
public class Tag {

    @Id
    private Long id;
    private String tagName;
    private String tagDesc;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="dim_id")
    private Dimension dimension;
    private Long createTime;

    @ManyToMany(mappedBy="tags", fetch=FetchType.EAGER)
    private Set<Movie> movies = new HashSet<Movie>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "tag_name")
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Column(name = "tag_desc")
    public String getTagDesc() {
        return tagDesc;
    }

    public void setTagDesc(String tagDesc) {
        this.tagDesc = tagDesc;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    @Column(name = "create_time")
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                ", tagDesc='" + tagDesc + '\'' +
                ", dimension=" + dimension +
                ", createTime=" + createTime +
                '}';
    }
}
