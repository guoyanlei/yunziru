package com.yunziru.movie.dao.impl;

import com.yunziru.movie.dto.MovieSimpleDTO;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by guoyanlei
 * Date：2017/11/6
 * Description：
 */
public class MovieDaoImpl {

    @Autowired
    private EntityManager em;

    /**
     * 获取电影概览信息
     * @param offset 偏移
     * @param limit 取的个数
     */
    public List<MovieSimpleDTO> getMovielist(int offset, int limit) {

        String hql = "select new com.yunziru.movie.dto.MovieSimpleDTO(id,title,name,poster,priseCount,createTime) from Movie order by id desc";

        return this.getListByHql(hql, offset, limit);
    }

    /**
     * 获取N热门电影概览信息
     * @param offset 偏移
     * @param limit 取的个数
     */
    public List<MovieSimpleDTO> getHotMovielist(int offset, int limit) {

        String hql = "select new com.yunziru.movie.dto.MovieSimpleDTO(id,title,name,poster,priseCount,createTime) from Movie order by hotCount desc";

        return this.getListByHql(hql, offset, limit);

    }

    /**
     * 获取N猜你喜欢热门电影概览信息
     * @param offset 偏移
     * @param limit 取的个数
     */
    public List<MovieSimpleDTO> getULikeMovielist(int offset, int limit) {

        String hql = "select new com.yunziru.movie.dto.MovieSimpleDTO(id,title,name,poster,priseCount,createTime) from Movie order by createTime desc";

        return this.getListByHql(hql, offset, limit);

    }

    public List<MovieSimpleDTO> getListByHql(String hql, int offset, int limit) {

        TypedQuery<MovieSimpleDTO> query = em.createQuery(hql, MovieSimpleDTO.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public List<MovieSimpleDTO> getMovieEntity() {
        String sql = "select t.id, t.title, t.poster from yunziru_movie t order by id desc limit 0,10";
        Query query = em.createNativeQuery(sql);
        query.unwrap(SQLQuery.class)
             .addScalar("id", StandardBasicTypes.LONG)
             .addScalar("title", StandardBasicTypes.STRING)
             .addScalar("poster", StandardBasicTypes.STRING)
             .setResultTransformer(Transformers.aliasToBean(MovieSimpleDTO.class));
        return query.getResultList();
    }
}
