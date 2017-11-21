package com.yunziru.tag.dao.impl;

import com.yunziru.common.dao.CustomBaseSqlDaoImpl;
import com.yunziru.common.dto.PageModel;
import com.yunziru.movie.entity.Movie;
import com.yunziru.tag.entity.Dimension;
import com.yunziru.tag.entity.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guoyanlei
 * Date：2017/11/6
 * Description：
 */
public class TagDaoImpl extends CustomBaseSqlDaoImpl {

    public PageModel<Dimension> queryDimPage(){
        Map<String,Object> map = new HashMap<String,Object>();
        StringBuilder hql = new StringBuilder();
        hql.append("SELECT DISTINCT d FROM Dimension d JOIN d.tags t where 1=1");
        return this.queryForPageWithParams(hql.toString(),map,1,10);
    }

    public PageModel<Tag> queryTagPage(){
        Map<String,Object> map = new HashMap<String,Object>();
        StringBuilder hql = new StringBuilder();
        hql.append("SELECT DISTINCT t FROM Tag t JOIN t.dimension d where t.dimension = 1");
        return this.queryForPageWithParams(hql.toString(),map,1,10);
    }

    public PageModel<Movie> queryMoviePage(){
        Map<String,Object> map = new HashMap<String,Object>();
        StringBuilder hql = new StringBuilder();
        hql.append("SELECT DISTINCT m FROM Movie m JOIN m.tags t where 1 = 1");
        return this.queryForPageWithParams(hql.toString(),map,1,10);
    }

    public PageModel<Tag> queryTagMoviePage(){
        Map<String,Object> map = new HashMap<String,Object>();
        StringBuilder hql = new StringBuilder();
        hql.append("SELECT DISTINCT t FROM Tag t JOIN t.movies m where 1 = 1");
        return this.queryForPageWithParams(hql.toString(),map,1,10);
    }
}
