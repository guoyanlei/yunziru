package com.yunziru.meiju.dto;

import com.alibaba.fastjson.JSONArray;

/**
 * Created by guoyanlei
 * Date：2017/12/22
 * Description：
 */
public class MeiJuDetailDTO extends MeiJuSimpleDTO{

    private String tagCh;
    private String categoryCh;
    private String summaryBase;
    private String summaryDesc;
    private JSONArray downLinks;

    public String getTagCh() {
        return tagCh;
    }

    public void setTagCh(String tagCh) {
        this.tagCh = tagCh;
    }

    public String getCategoryCh() {
        return categoryCh;
    }

    public void setCategoryCh(String categoryCh) {
        this.categoryCh = categoryCh;
    }

    public String getSummaryBase() {
        return summaryBase;
    }

    public void setSummaryBase(String summaryBase) {
        this.summaryBase = summaryBase;
    }

    public String getSummaryDesc() {
        return summaryDesc;
    }

    public void setSummaryDesc(String summaryDesc) {
        this.summaryDesc = summaryDesc;
    }

    public JSONArray getDownLinks() {
        return downLinks;
    }

    public void setDownLinks(JSONArray downLinks) {
        this.downLinks = downLinks;
    }
}
