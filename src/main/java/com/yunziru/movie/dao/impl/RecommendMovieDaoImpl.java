package com.yunziru.movie.dao.impl;

import com.yunziru.movie.entity.RecommendMovie;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by guoyanlei
 * Date：2017/11/6
 * Description：
 */
public class RecommendMovieDaoImpl {

    @Autowired
    private EntityManager em;

    /**
     * 获取推荐概览信息
     * @param offset 偏移
     * @param limit 取的个数
     */
    public List<RecommendMovie> getRCMMovielist(int offset, int limit) {

        String hql = "select r from RecommendMovie r order by id desc";

        TypedQuery<RecommendMovie> query = em.createQuery(hql, RecommendMovie.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.getResultList();
    }

}
