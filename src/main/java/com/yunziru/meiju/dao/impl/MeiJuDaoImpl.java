package com.yunziru.meiju.dao.impl;

import com.yunziru.meiju.dto.MeiJuSimpleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by guoyanlei
 * Date：2017/11/6
 * Description：
 */
public class MeiJuDaoImpl {

    @Autowired
    private EntityManager em;


    /**
     * 获取美剧概览信息
     * @param offset 偏移
     * @param limit 取的个数
     */
    public List<MeiJuSimpleDTO> getMeiJulist(String keyword, int offset, int limit) {

        StringBuilder hql = new StringBuilder("select new com.yunziru.meiju.dto.MeiJuSimpleDTO(id,title,image,priseCount,hotCount,date) from MeiJu ");
        if (!StringUtils.isEmpty(keyword)) {
            hql.append("where title like '%" + keyword + "%' ");
        }
        hql.append("order by id desc");

        return this.getListByHql(hql.toString(), offset, limit);
    }

    /**
     * 获取N热门美剧概览信息
     * @param offset 偏移
     * @param limit 取的个数
     */
    public List<MeiJuSimpleDTO> getHotMeiJuelist(int offset, int limit) {

        String hql = "select new com.yunziru.meiju.dto.MeiJuSimpleDTO(id,title,image,priseCount,hotCount,date) from MeiJu order by hotCount desc";

        return this.getListByHql(hql, offset, limit);

    }

    /**
     * 获取N猜你喜欢热门美剧概览信息
     * @param offset 偏移
     * @param limit 取的个数
     */
    public List<MeiJuSimpleDTO> getULikeMeiJulist(int offset, int limit) {

        String hql = "select new com.yunziru.meiju.dto.MeiJuSimpleDTO(id,title,image,priseCount,hotCount,date) from MeiJu order by createTime desc";

        return this.getListByHql(hql, offset, limit);

    }

    public List<MeiJuSimpleDTO> getListByHql(String hql, int offset, int limit) {

        TypedQuery<MeiJuSimpleDTO> query = em.createQuery(hql, MeiJuSimpleDTO.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.getResultList();
    }

}
