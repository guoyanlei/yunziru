package com.yunziru.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

    @Id
    private Integer id;

    private String name;

    private String pwd;

    @Column
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
