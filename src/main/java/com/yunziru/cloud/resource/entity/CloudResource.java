package com.yunziru.cloud.resource.entity;

import javax.persistence.*;

/**
 * Created by guoyanlei
 * Date：2017/10/23
 * Description：云资源
 */
@Entity
@Table(name = "yunziru_resource")
public class CloudResource {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String name;
    private String poster;      //海报
    private String summary;
    private String screenshot;
    private String ed2kLink;
    private String baiduLink;
    private Integer priseCount; //点赞数
    private Integer hotCount;   //访问热度
    private Long createTime;
    private Long updateTime;
    private String menu;        //菜单名称

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

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "menu")
    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    @Column(name = "poster")
    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
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

}
