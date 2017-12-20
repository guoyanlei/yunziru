package com.yunziru.meiju.service;

import com.google.common.collect.Lists;
import com.yunziru.common.service.CommonService;
import com.yunziru.common.util.PageUtil;
import com.yunziru.meiju.dao.MeiJuDao;
import com.yunziru.meiju.dao.impl.MeiJuDaoImpl;
import com.yunziru.meiju.dto.MeiJuSimpleDTO;
import com.yunziru.meiju.entity.MeiJu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Resource
    private MeiJuDaoImpl meiJuDaoImpl;

    @Autowired
    public void setMovieDao(MeiJuDao meiJuDao){
        super.setCommonDao(meiJuDao);
    }

    /**
     * 根据tid获取美剧
     * @param tid 爬取美剧网站的id
     */
    public MeiJu getMeiJuByTid(Long tid) {
        MeiJu meiJu = null;
        List<MeiJu> meiJuList = meiJuDao.findMeiJuByTid(tid);
        if(meiJuList != null && meiJuList.size() > 0){
            meiJu = meiJuList.get(0);
        }
        return meiJu;
    }

    /**
     * 获取美剧概览信息
     * @param page 当前页数
     * @param size 每页大小
     */
    public List<MeiJuSimpleDTO> getIndexMeiJuList(String keyword, int page, int size) {
        if ("".equals(keyword)) {
            return Lists.newArrayList();
        }
        return meiJuDaoImpl.getMeiJulist(keyword, PageUtil.getOffset(page, size), size);
    }

    /**
     * 获取热门美剧概览信息
     * @param page 当前页数
     * @param size 每页大小
     */
    public List<MeiJuSimpleDTO> getHotMeiJuList(int page, int size) {
        return meiJuDaoImpl.getHotMeiJuelist(PageUtil.getOffset(page, size), size);
    }

}
