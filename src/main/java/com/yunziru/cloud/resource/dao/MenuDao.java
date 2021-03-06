package com.yunziru.cloud.resource.dao;

import com.yunziru.common.dao.CommonDao;
import com.yunziru.cloud.resource.entity.Menu;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * Created by guoyanlei
 * date：2017/10/26
 * time：18:27
 * description：
 */
public interface MenuDao extends CommonDao<Menu, Long> {

    @Query("select m from Menu m where m.useStatus = 1 and m.parent = ?1 order by rank")
    List<Menu> findMenuByParent(Long parent);

    @Query("select m from Menu m where m.url = ?1")
    List<Menu> findMenuByUrl(String url);
}
