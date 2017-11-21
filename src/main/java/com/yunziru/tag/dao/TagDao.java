package com.yunziru.tag.dao;

import com.yunziru.common.dao.CommonDao;
import com.yunziru.tag.entity.Tag;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by guoyanlei
 * date：2017/10/26
 * time：18:27
 * description：
 */
public interface TagDao extends CommonDao<Tag, Long> {

    @Query("SELECT t FROM Tag t JOIN t.movies m where t.id = ?1 ")
    List<Tag> findTagById(Long id);
}
