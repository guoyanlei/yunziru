package com.yunziru.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by guoyanlei
 * date：2017/10/26
 * time：18:02
 * description：
 */
@Entity
@Table(name = "yunziru_user")
public class User {

    private Integer id;
    private String name;
    private String pwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
