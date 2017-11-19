package com.yunziru.admin.dao;

import com.yunziru.admin.entity.AdminUser;
import com.yunziru.common.dao.CommonDao;
import com.yunziru.movie.entity.Movie;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by guoyanlei
 * date：2017/10/26
 * time：18:27
 * description：
 */
public interface AdminUserDao extends CommonDao<AdminUser, Long> {

    @Query("select u from AdminUser u where u.username=?1 ")
    List<AdminUser> findUserByName(String userName);
}
