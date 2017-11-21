package service;

import com.yunziru.common.dto.PageModel;
import com.yunziru.common.util.PageUtil;
import com.yunziru.movie.entity.Movie;
import com.yunziru.tag.dao.DimensionDao;
import com.yunziru.tag.dao.MovieTagDao;
import com.yunziru.tag.dao.TagDao;
import com.yunziru.tag.dao.impl.TagDaoImpl;
import com.yunziru.tag.entity.Dimension;
import com.yunziru.tag.entity.Tag;
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
public class TagServiceTest {

    @Autowired
    private TagDaoImpl tagDaoImpl;

    @Autowired
    private DimensionDao dimensionDao;

    @Autowired
    private MovieTagDao movieTagDao;

    @Autowired
    private TagDao tagDao;

    @Test
    public void baseTest() {
        PageModel<Dimension> dims = tagDaoImpl.queryDimPage();
        for (Dimension dim : dims.getList()) {
            dim.getTags().forEach(System.out::println);
        }
    }

    @Test
    public void baseTagTest() {
        System.out.println(tagDaoImpl.queryTagPage());
    }

    @Test
    public void baseMovieTest() {
        PageModel<Movie> moviePage = tagDaoImpl.queryMoviePage();
        for (Movie movie : moviePage.getList()) {
            movie.getTags().forEach(System.out::println);
        }
    }

    @Test
    public void baseTagMovieTest() {
        PageModel<Tag> tagMoviePage = tagDaoImpl.queryTagMoviePage();
        for (Tag tag : tagMoviePage.getList()) {
            tag.getMovies().forEach(System.out::println);
        }
    }

    @Test
    public void baseDimTest() {
        System.out.println(dimensionDao.findDimensionById(1L));
    }

    @Test
    public void baseMovTest() {
        System.out.println(movieTagDao.findMovieById(50L));
    }

    @Test
    public void baseTagsTest() {
        System.out.println(tagDao.findTagById(1L));
    }
}
