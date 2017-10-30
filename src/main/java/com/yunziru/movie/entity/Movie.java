package com.yunziru.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by guoyanlei
 * Date：2017/10/23
 * Description：
 */
@Entity
@Table(name = "yunziru_movie")
public class Movie {

    @Id
    private Long id;
    private String title;
    private String poster;      //海报
    private String name;
    private String transName;
    private Integer year;
    private String location;
    private String type;
    private String language;
    private String releaseTime;
    private Integer lengthMins;
    private String summary;
    private String screenshot;
    private String ed2kLink;
    private String baiduLink;
    private String baiduPwd;
    private Integer tid;


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

    @Column(name = "trans_name")
    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName;
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

    @Column(name = "language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Column(name = "release_time")
    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    @Column(name = "length_mins")
    public Integer getLengthMins() {
        return lengthMins;
    }

    public void setLengthMins(Integer lengthMins) {
        this.lengthMins = lengthMins;
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

    public void setBaiduPwd(String baiduLinkPwd) {
        this.baiduPwd = baiduPwd;
    }

    @Column(name = "tid")
    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", poster='" + poster + '\'' +
                ", name='" + name + '\'' +
                ", transName='" + transName + '\'' +
                ", year=" + year +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", language='" + language + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", lengthMins=" + lengthMins +
                ", summary='" + summary + '\'' +
                ", screenshot='" + screenshot + '\'' +
                ", ed2kLink='" + ed2kLink + '\'' +
                ", baiduLink='" + baiduLink + '\'' +
                ", baiduPwd='" + baiduPwd + '\'' +
                ", tid=" + tid +
                '}';
    }
}
