package com.yunziru.common.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * 基础Dao接口定义
 * @author guoyanlei
 * @since 2017-10-30
 */
@NoRepositoryBean
public interface CommonDao<E,ID extends Serializable>  extends JpaRepository<E,ID>, JpaSpecificationExecutor<E> {

}
