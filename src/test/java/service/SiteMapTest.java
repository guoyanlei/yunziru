package service;

import com.redfin.sitemapgenerator.ChangeFreq;
import com.redfin.sitemapgenerator.WebSitemapGenerator;
import com.redfin.sitemapgenerator.WebSitemapUrl;
import com.yunziru.movie.entity.Movie;
import com.yunziru.movie.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;

/**
 * Created by guoyanlei
 * date：2017/12/8
 * time：23:05
 * description：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class SiteMapTest {

    private final static String outPath = "src/test/resources/";

    @Resource
    private MovieService movieService;

    @Test
    public void test() throws MalformedURLException {

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
