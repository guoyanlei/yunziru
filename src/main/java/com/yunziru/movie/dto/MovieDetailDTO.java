package com.yunziru.movie.dto;

import java.util.List;
import java.util.Map;

/**
 * Created by guoyanlei
 * Date：2017/11/2
 * Description：
 */
public class MovieDetailDTO {

    private Long id;
    private String title;
    private String summary;
    private List<String> images;
    private String baiduLink;
    private String baiduPwd;
    private Map<String, String> ed2kLinks;

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
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

    public Map<String, String> getEd2kLinks() {
        return ed2kLinks;
    }

    public void setEd2kLinks(Map<String, String> ed2kLinks) {
        this.ed2kLinks = ed2kLinks;
    }
}
