package service;

import com.yunziru.admin.Service.AdminUserService;
import com.yunziru.admin.entity.AdminUser;
import com.yunziru.movie.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by guoyanlei
 * date：2017/10/26
 * time：18:41
 * description：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class UserServiceTest {

    @Autowired
    private AdminUserService userService;

    @Test
    public void baseTest() {
        Page<AdminUser> userList = userService.findAll(new PageRequest(0, 10));
        System.out.println(userList.getContent().size());
    }


}
