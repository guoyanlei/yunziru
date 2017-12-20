package com.yunziru.meiju.service;

import com.yunziru.common.service.CommonService;
import com.yunziru.meiju.dao.MeiJuDao;
import com.yunziru.meiju.entity.MeiJu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by guoyanlei
 * Date：2017/12/17
 * Description：
 */
@Service
public class MeiJuService extends CommonService<MeiJu, Long> {

    @Autowired
    private MeiJuDao meiJuDao;

    @Autowired
    public void setMovieDao(MeiJuDao meiJuDao){
        super.setCommonDao(meiJuDao);
    }

    public MeiJu getMeiJuByTid(Long tid) {
        MeiJu meiJu = null;
        List<MeiJu> meiJuList = meiJuDao.findMeiJuByTid(tid);
        if(meiJuList != null && meiJuList.size() > 0){
            meiJu = meiJuList.get(0);
        }
        return meiJu;
    }
}
