package service;

import com.yunziru.movie.service.RecommendMovieService;
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
public class RCMMovieServiceTest {

    @Autowired
    private RecommendMovieService recommendMovieService;

    @Test
    public void baseTest() {
        System.out.println(recommendMovieService.getRCMMovielist(0,10));
    }

}
