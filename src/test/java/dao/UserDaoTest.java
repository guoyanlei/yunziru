package dao;

import com.yunziru.dao.UserDao;
import com.yunziru.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by guoyanlei
 * date：2017/10/26
 * time：18:41
 * description：
 */
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void baseTest() {
        User user = new User();

        user.setId(1);
        user.setName("guoyanlei");
        user.setPwd("111");

        userDao.save(user);
    }
}
