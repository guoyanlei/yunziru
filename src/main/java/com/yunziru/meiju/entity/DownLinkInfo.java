package com.yunziru.meiju.entity;

import com.qiniu.util.StringUtils;

/**
 * Created by guoyanlei
 * date：2017/12/16
 * time：19:36
 * description：
 */
public class DownLinkInfo {

    private String title;
    private String ed2k;
    private String magnet;
    private String wangpan;
    private String size;

    public boolean isNotNull() {
        return !StringUtils.isNullOrEmpty(title) && !StringUtils.isNullOrEmpty(ed2k);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEd2k() {
        return ed2k;
    }

    public void setEd2k(String ed2k) {
        this.ed2k = ed2k;
    }

    public String getMagnet() {
        return magnet;
    }

    public void setMagnet(String magnet) {
        this.magnet = magnet;
    }

    public String getWangpan() {
        return wangpan;
    }

    public void setWangpan(String wangpan) {
        this.wangpan = wangpan;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "DownLinkInfo{" +
                "title='" + title + '\'' +
                ", ed2k='" + ed2k + '\'' +
                ", magnet='" + magnet + '\'' +
                ", wangpan='" + wangpan + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
