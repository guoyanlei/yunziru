package com.yunziru.movie.dto;

/**
 * Created by guoyanlei
 * Date：2017/11/6
 * Description：
 */
public class MovieSimpleDTO {

    private Long id;
    private String title;
    private String poster;      //海报

    public MovieSimpleDTO() {
    }

    public MovieSimpleDTO(Long id, String title, String poster) {
        this.id = id;
        this.title = title;
        this.poster = poster;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "MovieSimpleDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
