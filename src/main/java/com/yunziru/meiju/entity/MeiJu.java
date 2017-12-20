package com.yunziru.meiju.entity;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

/**
 * Created by guoyanlei
 * date：2017/12/16
 * time：22:02
 * description：
 */
@Entity
@Table(name = "yunziru_meiju")
public class MeiJu {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String date;
    private String image;
    private String summary;
    private String downLinks;
    private String updateStatus;//更新状态
    private String tagCh;       //中文标签
    private String tagEn;       //英文标签
    private String categoryCh;  //中文分类
    private String categoryEn;  //英文分类
    private boolean isEnd;      //是否完结
    private Long tid;        //爬取美剧网站的id
    private Integer priseCount; //点赞数
    private Integer hotCount;   //访问热度
    private Long createTime;
    private Long updateTime;

    public static MeiJu of(MeiJuSimple meiJuSimple){
        MeiJu meiJu = new MeiJu();
        meiJu.setTid(meiJuSimple.getTid());
        meiJu.setUpdateStatus(meiJuSimple.getUpdateStatus());
        meiJu.setTagCh(meiJuSimple.getTagCH());
        meiJu.setTagEn(meiJuSimple.getTagEN());
        meiJu.setCategoryCh(meiJuSimple.getCategoryCH());
        meiJu.setCategoryEn(meiJuSimple.getCategoryEN());
        meiJu.setEnd(meiJuSimple.isEnd());
        return meiJu;
    }

    public boolean downLinksNotNull() {
        return !"[]".equals(downLinks);
    }

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

    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Column(name = "down_links")
    public String getDownLinks() {
        return downLinks;
    }

    public void setDownLinks(String downLinks) {
        this.downLinks = downLinks;
    }

    @Column(name = "update_status")
    public String getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus;
    }

    @Column(name = "tag_ch")
    public String getTagCh() {
        return tagCh;
    }

    public void setTagCh(String tagCh) {
        this.tagCh = tagCh;
    }
    @Column(name = "tag_en")
    public String getTagEn() {
        return tagEn;
    }

    public void setTagEn(String tagEn) {
        this.tagEn = tagEn;
    }
    @Column(name = "category_ch")
    public String getCategoryCh() {
        return categoryCh;
    }

    public void setCategoryCh(String categoryCh) {
        this.categoryCh = categoryCh;
    }
    @Column(name = "category_en")
    public String getCategoryEn() {
        return categoryEn;
    }

    public void setCategoryEn(String categoryEn) {
        this.categoryEn = categoryEn;
    }
    @Column(name = "is_end")
    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
    @Column(name = "tid")
    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
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
}
