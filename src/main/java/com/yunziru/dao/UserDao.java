package com.yunziru.dao;

import com.yunziru.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

/**
 * Created by guoyanlei
 * date：2017/10/26
 * time：18:27
 * description：
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer>{
}
