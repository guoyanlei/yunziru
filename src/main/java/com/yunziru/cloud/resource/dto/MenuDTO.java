package com.yunziru.cloud.resource.dto;

import com.yunziru.cloud.resource.entity.Menu;

import java.util.List;

/**
 * Created by guoyanlei
 * Date：2017/12/22
 * Description：
 */
public class MenuDTO {

    private String name;
    private String url;
    private List<Menu> subMenus;

    public MenuDTO() {
    }

    public MenuDTO(String name, String url, List<Menu> subMenus) {
        this.name = name;
        this.url = url;
        this.subMenus = subMenus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Menu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<Menu> subMenus) {
        this.subMenus = subMenus;
    }
}
