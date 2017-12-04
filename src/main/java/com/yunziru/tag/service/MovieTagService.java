package com.yunziru.tag.service;

import com.yunziru.common.service.CommonService;
import com.yunziru.tag.dao.MovieTagDao;
import com.yunziru.tag.entity.MovieTag;
import com.yunziru.tag.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by guoyanlei
 * Date：2017/12/4
 * Description：
 */
@Service
public class MovieTagService extends CommonService<MovieTag, Long> {

    @Autowired
    public void setMovieTagDao(MovieTagDao movieTagDao){
        super.setCommonDao(movieTagDao);
    }
}
