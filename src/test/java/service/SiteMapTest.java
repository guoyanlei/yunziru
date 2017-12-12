package service;

import com.yunziru.sitemap.SiteMapCreater;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.net.MalformedURLException;

/**
 * Created by guoyanlei
 * date：2017/12/8
 * time：23:05
 * description：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class SiteMapTest {

    @Resource
    private SiteMapCreater siteMapCreater;

    @Test
    public void test() throws MalformedURLException {

        siteMapCreater.execute();
    }
}
