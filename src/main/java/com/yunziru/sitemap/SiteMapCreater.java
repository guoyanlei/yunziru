package com.yunziru.sitemap;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.qiniu.util.StringUtils;
import com.redfin.sitemapgenerator.ChangeFreq;
import com.redfin.sitemapgenerator.WebSitemapGenerator;
import com.redfin.sitemapgenerator.WebSitemapUrl;
import com.yunziru.common.util.QiniuUtil;
import com.yunziru.movie.crawler.MovieCrawler;
import com.yunziru.movie.entity.Movie;
import com.yunziru.movie.service.MovieService;
import com.yunziru.tag.entity.MovieTag;
import com.yunziru.tag.entity.Tag;
import com.yunziru.tag.service.MovieTagService;
import com.yunziru.tag.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by guoyanlei
 * Date：2017/12/3
 * Description：
 */
@Service
public class SiteMapCreater {

    private static final Logger LOG = LoggerFactory.getLogger(SiteMapCreater.class);

    private final static String outPath = "src/main/webapp/";

    @Resource
    private MovieService movieService;

    public void execute() throws MalformedURLException {

        File siteMapFile = new File(outPath);
        WebSitemapGenerator wsg = new WebSitemapGenerator("http://yunziru.com.cn", siteMapFile);
        WebSitemapUrl url = new WebSitemapUrl.Options("http://yunziru.com.cn")
                .lastMod(new Date()).priority(1.0).changeFreq(ChangeFreq.DAILY).build();
        wsg.addUrl(url);

        url = new WebSitemapUrl.Options("http://yunziru.com.cn/hot")
                .lastMod(new Date()).priority(0.8).changeFreq(ChangeFreq.DAILY).build();
        wsg.addUrl(url);
        url = new WebSitemapUrl.Options("http://yunziru.com.cn/recommend")
                .lastMod(new Date()).priority(0.8).changeFreq(ChangeFreq.DAILY).build();
        wsg.addUrl(url);

        List<Movie> movieList = movieService.getAll();
        movieList.forEach(movie -> {
            try {
                WebSitemapUrl sitemapUrl = new WebSitemapUrl.Options("http://yunziru.com.cn/" + movie.getId() + "/detail")
                        .lastMod(new Date()).priority(0.6).changeFreq(ChangeFreq.MONTHLY).build();
                wsg.addUrl(sitemapUrl);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        });
        wsg.write();

    }
}
