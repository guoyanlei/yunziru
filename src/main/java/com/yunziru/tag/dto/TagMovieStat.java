package com.yunziru.tag.dto;

/**
 * Created by guoyanlei
 * Date：2017/11/21
 * Description：
 */
public class TagMovieStat implements Comparable<TagMovieStat>{

    private Long tagId;

    private String tagName;

    private Integer movieCount;

    public TagMovieStat() {
    }

    public TagMovieStat(Long tagId, String tagName, Integer movieCount) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.movieCount = movieCount;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getMovieCount() {
        return movieCount;
    }

    public void setMovieCount(Integer movieCount) {
        this.movieCount = movieCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TagMovieStat that = (TagMovieStat) o;

        return movieCount.equals(that.movieCount);

    }

    @Override
    public int hashCode() {
        return movieCount.hashCode();
    }

    @Override
    public String toString() {
        return "TagMovieStat{" +
                "tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                ", movieCount=" + movieCount +
                '}';
    }

    @Override
    public int compareTo(TagMovieStat o) {
        return this.movieCount.compareTo(o.movieCount);
    }
}
