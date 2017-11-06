package service;

import com.yunziru.movie.service.MovieService;
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
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    public void baseTest() {
        System.out.println(movieService.find(1L));
    }

    @Test
    public void getListTest() {
        System.out.println(movieService.getMovieList());
    }


    @Test
    public void getList2Test() {
        System.out.println(movieService.getSimpleMovieList());
    }
}
