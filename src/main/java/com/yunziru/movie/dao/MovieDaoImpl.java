package com.yunziru.movie.dao;

import com.yunziru.movie.dto.MovieSimpleDTO;
import com.yunziru.movie.entity.Movie;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

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

    public List<MovieSimpleDTO> getMovielist() {

        String hql = "select new com.yunziru.movie.dto.MovieSimpleDTO(id,title,poster) from Movie where id = :id order by id desc";

        TypedQuery<MovieSimpleDTO> query = em.createQuery(hql, MovieSimpleDTO.class);
        query.setParameter("id", 2L);
        return query.getResultList();
    }

    public List<MovieSimpleDTO> getMovieEntity() {
        String sql = "select t.id, t.title, t.poster from yunziru_movie t order by id desc limit 0,10";
        Query query = em.createNativeQuery(sql);
        query.unwrap(SQLQuery.class)
                // 这里是设置字段的数据类型，有几点注意，首先这里的字段名要和目标实体的字段名相同，然后 sql 语句中的名称（别名）得与实体的相同
                .addScalar("id", StandardBasicTypes.LONG)
                .addScalar("title", StandardBasicTypes.STRING)
                .addScalar("poster", StandardBasicTypes.STRING)
                .setResultTransformer(Transformers.aliasToBean(MovieSimpleDTO.class));
        return query.getResultList();
    }
}
