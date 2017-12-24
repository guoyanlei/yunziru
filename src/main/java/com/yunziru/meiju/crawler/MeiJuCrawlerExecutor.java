package com.yunziru.meiju.crawler;

import com.qiniu.util.StringUtils;
import com.yunziru.common.util.QiniuUtil;
import com.yunziru.meiju.entity.MeiJu;
import com.yunziru.meiju.entity.MeiJuSimple;
import com.yunziru.meiju.service.MeiJuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by guoyanlei
 * Date：2017/12/3
 * Description：
 */
@Service
public class MeiJuCrawlerExecutor {

    private static final Logger LOG = LoggerFactory.getLogger(MeiJuCrawlerExecutor.class);

    //奇幻/科幻
    public final static String MEIJU_qhkh_URL = "http://www.msj1.com/c/qhkh/page/";
    public final static int MEIJU_qhkh_SIZE = 43;
    //律政/医务
    public final static String MEIJU_lzyw_URL = "http://www.msj1.com/c/lzyw/page/";
    public final static int MEIJU_lzyw_SIZE = 15;
    //情景/喜剧
    public final static String MEIJU_qjxj_URL = "http://www.msj1.com/c/qjxj/page/";
    public final static int MEIJU_qjxj_SIZE = 52;
    //罪案/谍战
    public final static String MEIJU_zadz_URL = "http://www.msj1.com/c/zadz/page/";
    public final static int MEIJU_zadz_SIZE = 55;
    //历史/剧情
    public final static String MEIJU_lsjq_URL = "http://www.msj1.com/c/lsjq/page/";
    public final static int MEIJU_lsjq_SIZE = 28;
    //动作/战争
    public final static String MEIJU_zzzz_URL = "http://www.msj1.com/c/zzzz/page/";
    public final static int MEIJU_zzzz_SIZE = 7;
    //都市/情感
    public final static String MEIJU_dsqg_URL = "http://www.msj1.com/c/dsqg/page/";
    public final static int MEIJU_dsqg_SIZE = 20;
    //灵异/惊悚
    public final static String MEIJU_lyjs_URL = "http://www.msj1.com/c/lyjs/page/";
    public final static int MEIJU_lyjs_SIZE = 19;
    //动漫/卡通
    public final static String MEIJU_dmkt_URL = "http://www.msj1.com/c/dmkt/page/";
    public final static int MEIJU_dmkt_SIZE = 9;
    //纪录片
    public final static String MEIJU_jlp_URL = "http://www.msj1.com/c/jlp/page/";
    public final static int MEIJU_jlp_SIZE = 3;

    @Resource
    private MeijuCrawler crawlerWorker;

    @Resource
    private MeiJuService meiJuService;

    public void execute() {

        for (int i = MEIJU_dmkt_SIZE; i >= 1; i--) {
            String content = crawlerWorker.getResponseContent(MEIJU_dmkt_URL + i);
            List<MeiJuSimple> meiJuSimples = crawlerWorker.parseMeijuList(content);
            meiJuSimples.forEach(meiJuSimple -> {
                String meijuContent = crawlerWorker.getResponseContent(meiJuSimple.getUrl());
                MeiJu meiJu = crawlerWorker.parseMeiju(meijuContent, meiJuSimple);
                if (meiJu.downLinksNotNull()) {
                    if (!StringUtils.isNullOrEmpty(meiJu.getImage())) {
                        String qiniuUrl = QiniuUtil.storeMeiJuImage(meiJu.getImage());
                        if (StringUtils.isNullOrEmpty(qiniuUrl)) {
                            qiniuUrl = QiniuUtil.storeRandomImage(meiJu.getImage());
                        }
                        meiJu.setImage(qiniuUrl);
                    }
                    MeiJu origin = meiJuService.getMeiJuByTid(meiJu.getTid());
                    if (origin != null) {
                        meiJu.setId(origin.getId());
                        meiJu.setHotCount(origin.getHotCount());
                        meiJu.setPriseCount(origin.getPriseCount());
                        meiJu.setCreateTime(origin.getCreateTime());
                        meiJu.setUpdateTime(System.currentTimeMillis());
                        meiJuService.update(meiJu);
                    } else {
                        meiJu.setHotCount(0);
                        meiJu.setPriseCount(0);
                        meiJu.setCreateTime(System.currentTimeMillis());
                        meiJu.setUpdateTime(System.currentTimeMillis());
                        meiJuService.save(meiJu);
                    }
                    System.out.println(meiJu.getTid() + " -- " + meiJu.getImage());
                }
            });
        }
    }

}
