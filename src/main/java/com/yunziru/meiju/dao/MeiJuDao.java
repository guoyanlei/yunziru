package com.yunziru.meiju.dao;

import com.yunziru.common.dao.CommonDao;
import com.yunziru.meiju.entity.MeiJu;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by guoyanlei
 * date：2017/10/26
 * time：18:27
 * description：
 */
public interface MeiJuDao extends CommonDao<MeiJu, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update MeiJu m set m.priseCount = m.priseCount+1 where m.id = ?1")
    int updatePriseCountById(Long id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update MeiJu m set m.hotCount = m.hotCount+1 where m.id = ?1")
    int updateHotCountById(Long id);

    @Query("select m from MeiJu m where m.tid = ?1 ")
    List<MeiJu> findMeiJuByTid(Long tid);
}
