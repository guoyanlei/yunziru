package com.yunziru.meiju.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.yunziru.common.service.CommonService;
import com.yunziru.common.util.PageUtil;
import com.yunziru.meiju.dao.MeiJuDao;
import com.yunziru.meiju.dao.impl.MeiJuDaoImpl;
import com.yunziru.meiju.dto.MeiJuDetailDTO;
import com.yunziru.meiju.dto.MeiJuSimpleDTO;
import com.yunziru.meiju.entity.MeiJu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * Created by guoyanlei
 * Date：2017/12/17
 * Description：
 */
@Service
public class MeiJuService extends CommonService<MeiJu, Long> {

    private final static int RANDOM_COUNT = 5;
    private final static int ULIKE_COUNT = 4;

    @Autowired
    private MeiJuDao meiJuDao;

    @Resource
    private MeiJuDaoImpl meiJuDaoImpl;

    @Autowired
    public void setMovieDao(MeiJuDao meiJuDao){
        super.setCommonDao(meiJuDao);
    }

    /**
     * 对美剧点赞
     */
    public boolean updatePriseCount(Long id) {
        return meiJuDao.updatePriseCountById(id)> 0;
    }

    /**
     * 浏览美剧
     */
    public boolean updateHotCount(Long id) {
        return meiJuDao.updateHotCountById(id)> 0;
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
    public List<MeiJuSimpleDTO> getIndexMeiJuList(String keyword, String category, int page, int size) {
        if ("".equals(keyword)) {
            return Lists.newArrayList();
        }
        return meiJuDaoImpl.getMeiJulist(keyword, category, PageUtil.getOffset(page, size), size);
    }

    /**
     * 获取热门美剧概览信息
     * @param page 当前页数
     * @param size 每页大小
     */
    public List<MeiJuSimpleDTO> getHotMeiJuList(int page, int size) {
        return meiJuDaoImpl.getHotMeiJuelist(PageUtil.getOffset(page, size), size);
    }

    /**
     * 获取美剧资源详情
     * @param meijuId 美剧id
     * @return 资源详情
     */
    public MeiJuDetailDTO getMeiJuDetailInfo(Long meijuId) {

        MeiJu meiJu = super.find(meijuId);

        MeiJuDetailDTO detailDTO = new MeiJuDetailDTO();
        detailDTO.setId(meiJu.getId());
        detailDTO.setTitle(meiJu.getTitle());
        detailDTO.setPoster(meiJu.getImage());
        detailDTO.setUpdateStatus(meiJu.getUpdateStatus());
        detailDTO.setPriseCount(meiJu.getPriseCount());
        detailDTO.setHotCount(meiJu.getHotCount());
        detailDTO.setDate(meiJu.getDate());
        detailDTO.setTagCh(meiJu.getTagCh());
        detailDTO.setCategoryCh(meiJu.getCategoryCh());
        detailDTO.setSummaryBase(meiJu.getSummary().substring(0, meiJu.getSummary().indexOf("<h")));
        String summaryDesc = meiJu.getSummary().substring(meiJu.getSummary().indexOf("<h"), meiJu.getSummary().length());
        detailDTO.setSummaryDesc(summaryDesc.replaceAll("<a href=(.+?)>", "").replaceAll("</a>",""));
        detailDTO.setDownLinks(JSON.parseArray(meiJu.getDownLinks()));

        return detailDTO;
    }

    /**
     * 随机获取N个猜你喜欢电影
     */
    public List<MeiJuSimpleDTO> getULikeMeiJu() {
        List<MeiJuSimpleDTO> meiJuSimpleDTOs = meiJuDaoImpl.getULikeMeiJulist(0, 100);

        List<MeiJuSimpleDTO> result = Lists.newArrayList();
        Random rand = new Random();
        int size = meiJuSimpleDTOs.size() < ULIKE_COUNT ? meiJuSimpleDTOs.size() : ULIKE_COUNT;

        for (int i = 0; i< size; i++) {
            int randomNum=rand.nextInt(meiJuSimpleDTOs.size());
            result.add(meiJuSimpleDTOs.get(randomNum));
            meiJuSimpleDTOs.remove(randomNum);
        }
        return result;
    }

    /**
     * 随机获取N个热门美剧
     */
    public List<MeiJuSimpleDTO> getRandomHotMeiJu() {
        List<MeiJuSimpleDTO> meiJuSimpleDTOs = meiJuDaoImpl.getHotMeiJuelist(0, 100);

        List<MeiJuSimpleDTO> result = Lists.newArrayList();
        Random rand = new Random();
        int size = meiJuSimpleDTOs.size() < RANDOM_COUNT ? meiJuSimpleDTOs.size() : RANDOM_COUNT;

        for (int i = 0; i< size; i++) {
            int randomNum=rand.nextInt(meiJuSimpleDTOs.size());
            result.add(meiJuSimpleDTOs.get(randomNum));
            meiJuSimpleDTOs.remove(randomNum);
        }
        return result;
    }
}
