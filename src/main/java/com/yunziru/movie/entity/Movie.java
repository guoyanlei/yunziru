package com.yunziru.movie.entity;

import com.yunziru.tag.entity.Tag;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by guoyanlei
 * Date：2017/10/23
 * Description：电影
 */
@Entity
@Table(name = "yunziru_movie")
public class Movie {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String poster;      //海报
    private String name;
    private Integer year;
    private String location;
    private String type;
    private String summary;
    private String screenshot;
    private String ed2kLink;
    private String baiduLink;
    private String baiduPwd;
    private Integer tid;        //爬取电影网站的id
    private Integer priseCount; //点赞数
    private Integer hotCount;   //访问热度
    private Long createTime;
    private Long updateTime;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="yunziru_movie_tag",joinColumns=@JoinColumn(name="movieId"),
               inverseJoinColumns=@JoinColumn(name="tagId"))
    private Set<Tag> tags = new HashSet<Tag>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "poster")
    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "year")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Column(name = "screenshot")
    public String getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot;
    }

    @Column(name = "ed2k_link")
    public String getEd2kLink() {
        return ed2kLink;
    }

    public void setEd2kLink(String ed2kLink) {
        this.ed2kLink = ed2kLink;
    }

    @Column(name = "baidu_link")
    public String getBaiduLink() {
        return baiduLink;
    }

    public void setBaiduLink(String baiduLink) {
        this.baiduLink = baiduLink;
    }

    @Column(name = "baidu_pwd")
    public String getBaiduPwd() {
        return baiduPwd;
    }

    public void setBaiduPwd(String baiduPwd) {
        this.baiduPwd = baiduPwd;
    }

    @Column(name = "tid")
    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @Column(name = "prise_count")
    public Integer getPriseCount() {
        return priseCount;
    }

    public void setPriseCount(Integer priseCount) {
        this.priseCount = priseCount;
    }

    @Column(name = "hot_count")
    public Integer getHotCount() {
        return hotCount;
    }

    public void setHotCount(Integer hotCount) {
        this.hotCount = hotCount;
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

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", poster='" + poster + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", summary='" + summary + '\'' +
                ", screenshot='" + screenshot + '\'' +
                ", ed2kLink='" + ed2kLink + '\'' +
                ", baiduLink='" + baiduLink + '\'' +
                ", baiduPwd='" + baiduPwd + '\'' +
                ", tid=" + tid +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
