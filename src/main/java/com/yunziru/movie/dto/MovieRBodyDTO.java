package com.yunziru.movie.dto;

/**
 * Created by guoyanlei
 * date：2017/11/30
 * time：17:05
 * description：添加修改时的请求响应封装bean
 */
public class MovieRBodyDTO {

    private Long id;
    private String title;
    private String name;
    private Integer year;
    private String location;
    private String type;
    private String ed2kLink;
    private String baiduLink;
    private String baiduPwd;
    private Integer tid;
    private String summary;
    private String images;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEd2kLink() {
        return ed2kLink;
    }

    public void setEd2kLink(String ed2kLink) {
        this.ed2kLink = ed2kLink;
    }

    public String getBaiduLink() {
        return baiduLink;
    }

    public void setBaiduLink(String baiduLink) {
        this.baiduLink = baiduLink;
    }

    public String getBaiduPwd() {
        return baiduPwd;
    }

    public void setBaiduPwd(String baiduPwd) {
        this.baiduPwd = baiduPwd;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "MovieRBodyDTO{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", ed2kLink='" + ed2kLink + '\'' +
                ", baiduLink='" + baiduLink + '\'' +
                ", baiduPwd='" + baiduPwd + '\'' +
                ", tid='" + tid + '\'' +
                ", summary='" + summary + '\'' +
                ", images='" + images + '\'' +
                '}';
    }
}
