package com.yunziru.dao;

import com.yunziru.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by guoyanlei
 * date：2017/10/26
 * time：18:27
 * description：
 */
@NoRepositoryBean
public interface UserDao extends JpaRepository<User, Integer>{
}
