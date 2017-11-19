package com.yunziru.admin.Service;

import com.yunziru.admin.dao.AdminUserDao;
import com.yunziru.admin.entity.AdminUser;
import com.yunziru.common.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by guoyanlei
 * date：2017/11/18
 * time：20:56
 * description：
 */
@Service
public class AdminUserService extends CommonService<AdminUser, Long> {

    @Autowired
    private AdminUserDao adminUserDao;

    @Autowired
    public void setAdminUserDao(AdminUserDao adminUserDao){
        super.setCommonDao(adminUserDao);
    }

    public AdminUser findUserByName(String userName){
        AdminUser user = null;
        List<AdminUser> userList = this.adminUserDao.findUserByName(userName);
        if(userList != null && userList.size() > 0){
            user = userList.get(0);
        }
        return user;
    }
}
