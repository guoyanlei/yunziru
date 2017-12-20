package com.yunziru.meiju.dto;

/**
 * Created by guoyanlei
 * Date：2017/11/6
 * Description：
 */
public class MeiJuSimpleDTO {

    private Long id;
    private String title;
    private String poster;
    private Integer priseCount;
    private Integer hotCount;
    private String date;

    public MeiJuSimpleDTO() {
    }

    public MeiJuSimpleDTO(Long id, String title, String poster, Integer priseCount, Integer hotCount, String date) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.priseCount = priseCount;
        this.hotCount = hotCount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Integer getPriseCount() {
        return priseCount;
    }

    public void setPriseCount(Integer priseCount) {
        this.priseCount = priseCount;
    }

    public Integer getHotCount() {
        return hotCount;
    }

    public void setHotCount(Integer hotCount) {
        this.hotCount = hotCount;
    }

    public static MeiJuSimpleDTO of(Long id, String title, String poster, Integer priseCount, Integer hotCount, String date) {
        return new MeiJuSimpleDTO(id, title, poster, priseCount, hotCount, date);
    }

    @Override
    public String toString() {
        return "MeiJuSimpleDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", poster='" + poster + '\'' +
                ", priseCount=" + priseCount +
                ", hotCount=" + hotCount +
                ", date='" + date + '\'' +
                '}';
    }
}
