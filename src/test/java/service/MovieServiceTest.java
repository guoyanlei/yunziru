package service;

import com.yunziru.movie.service.MovieService;
import com.yunziru.tag.service.TagService;
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

    @Autowired
    private TagService tagService;

    @Test
    public void baseTest() {
        System.out.println(movieService.find(1L));
    }

    @Test
    public void getListTest() {
        System.out.println(movieService.getHotMovieList(2, 10));
    }


    @Test
    public void testUpdate() {
        System.out.println(movieService.updatePriseCount(1L));
    }

    @Test
    public void testUpdateHotCount() {
        System.out.println(movieService.updateHotCount(1L));
        System.out.println(movieService.getIndexMovieList("", 2, 10));
    }

    @Test
    public void baseMovieTagStatTest() {
        System.out.println(tagService.getMovieTagStats(50L));
    }

}
