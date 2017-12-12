package com.yunziru.sitemap;

import com.redfin.sitemapgenerator.ChangeFreq;
import com.redfin.sitemapgenerator.WebSitemapGenerator;
import com.redfin.sitemapgenerator.WebSitemapUrl;
import com.yunziru.movie.entity.Movie;
import com.yunziru.movie.service.MovieService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;

/**
 * Created by guoyanlei
 * Date：2017/12/3
 * Description：
 */
@Service
public class SiteMapCreater {

    private static Logger logger = Logger.getLogger(SiteMapCreater.class);

    private final static String outPath = "src/main/webapp/";

    @Resource
    private MovieService movieService;

    public void execute() throws MalformedURLException {

        String path = getClass().getProtectionDomain().getCodeSource().getLocation().toString();
        logger.info(path);
        int index = path.indexOf("WEB-INF");
        File siteMapFile;
        if(index == -1){
            siteMapFile = new File(outPath);
        } else {
            String newPath = path.split(":")[1];
            siteMapFile = new File(newPath.substring(0, newPath.indexOf("WEB-INF")));
        }

        WebSitemapGenerator wsg = new WebSitemapGenerator("http://yunziru.com.cn", siteMapFile);
        WebSitemapUrl url = new WebSitemapUrl.Options("http://yunziru.com.cn")
                .lastMod(new Date()).priority(1.0).changeFreq(ChangeFreq.MONTHLY).build();
        wsg.addUrl(url);

        url = new WebSitemapUrl.Options("http://yunziru.com.cn/hot")
                .lastMod(new Date()).priority(0.8).changeFreq(ChangeFreq.MONTHLY).build();
        wsg.addUrl(url);
        url = new WebSitemapUrl.Options("http://yunziru.com.cn/recommend")
                .lastMod(new Date()).priority(0.8).changeFreq(ChangeFreq.MONTHLY).build();
        wsg.addUrl(url);

        List<Movie> movieList = movieService.getAll();
        movieList.forEach(movie -> {
            try {
                WebSitemapUrl sitemapUrl = new WebSitemapUrl.Options("http://yunziru.com.cn/movies/" + movie.getId() + "/detail")
                        .lastMod(new Date(movie.getCreateTime())).priority(0.6).changeFreq(ChangeFreq.MONTHLY).build();
                wsg.addUrl(sitemapUrl);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        });
        wsg.write();
        logger.info("sitemap.xml has been created");
    }
}
