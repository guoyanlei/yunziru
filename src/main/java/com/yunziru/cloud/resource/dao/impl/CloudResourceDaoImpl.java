package com.yunziru.cloud.resource.dao.impl;

import com.yunziru.cloud.resource.dto.CloudResourceSimpleDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by guoyanlei
 * Date：2017/12/10
 * Description：
 */
public class CloudResourceDaoImpl {

    @Autowired
    private EntityManager em;

    /**
     * 获取资源概览信息
     * @param offset 偏移
     * @param limit 取的个数
     */
    public List<CloudResourceSimpleDTO> getResourcelist(String keyword, int offset, int limit, String menu) {

        StringBuilder hql = new StringBuilder("select new com.yunziru.cloud.resource.dto.CloudResourceSimpleDTO(id,title,name,poster,priseCount,hotCount,createTime) from CloudResource ");
        hql.append("where menu = '" + menu + "'");
        if (!StringUtils.isEmpty(keyword)) {
            hql.append(" and title like '%" + keyword + "%' ");
        }
        hql.append(" order by id desc");

        return this.getListByHql(hql.toString(), offset, limit);
    }

    public List<CloudResourceSimpleDTO> getListByHql(String hql, int offset, int limit) {

        TypedQuery<CloudResourceSimpleDTO> query = em.createQuery(hql, CloudResourceSimpleDTO.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.getResultList();
    }
}
