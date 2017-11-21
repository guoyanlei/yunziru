package com.yunziru.tag.dao;

import com.yunziru.common.dao.CommonDao;
import com.yunziru.tag.entity.Dimension;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by guoyanlei
 * date：2017/10/26
 * time：18:27
 * description：
 */
public interface DimensionDao extends CommonDao<Dimension, Long> {

    @Query("SELECT d FROM Dimension d JOIN d.tags t where d.id = ?1 ")
    List<Dimension> findDimensionById(Long id);
}
