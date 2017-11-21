package com.yunziru.tag.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by guoyanlei
 * date：2017/11/11
 * time：21:17
 * description：标签维度
 */
@Entity
@Table(name = "yunziru_dimension")
public class Dimension {

    @Id
    private Long id;
    private String dimension;
    private String desc;
    private Long createTime;

    @OneToMany(mappedBy="dimension",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<Tag> tags = new HashSet<Tag>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "dimension")
    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    @Column(name = "desc")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Column(name = "create_time")
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Dimension{" +
                "id=" + id +
                ", dimension='" + dimension + '\'' +
                ", desc='" + desc + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
