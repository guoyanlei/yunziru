package service;

import com.yunziru.meiju.crawler.MeiJuCrawlerExecutor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by guoyanlei
 * date：2017/10/26
 * time：18:41
 * description：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MeiJuCrawlerTest {

    @Autowired
    private MeiJuCrawlerExecutor meiJuCrawlerExecutor;

    @Test
    public void exeTest() {
        meiJuCrawlerExecutor.execute();
    }

}
