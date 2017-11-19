package com.yunziru.web.backend;

import com.yunziru.admin.Service.AdminUserService;
import com.yunziru.admin.entity.AdminUser;
import com.yunziru.common.util.Md5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * Created by guoyanlei
 * date：2017/11/18
 * time：21:01
 * description：
 */
@Controller
@RequestMapping("backend/users")
public class UserController {

    @Resource
    private AdminUserService adminUserService;

    @RequestMapping("")
    public String userList(@RequestParam(defaultValue = "1", required = false) int page,
                           @RequestParam(defaultValue = "10", required = false) int size,
                           ModelMap modelMap){
        PageRequest pageRequest = new PageRequest(page-1, size);
        modelMap.put("users", adminUserService.findAll(pageRequest));
        modelMap.put("active_menu","user_list");
        return "backend/user_list";
    }

    @RequestMapping("add")
    public String userAdd(@RequestParam(value = "id", required = false) Long id,
                          ModelMap modelMap){

        modelMap.put("active_menu","user_list");
        if(Objects.isNull(id)) {
            return "backend/user_add";
        } else {
            AdminUser user = adminUserService.find(id);
            modelMap.put("user", user);
            return "backend/user_add";
        }
    }

    @RequestMapping("delete")
    public String userDelete(@RequestParam(value = "id", required = false) Long id,
                             ModelMap modelMap){
        adminUserService.delete(id);
        return "redirect:/backend/users";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String addUser(@RequestParam(value = "id", required = false) Long id,
                          @RequestParam(value = "userName", required = true) String userName,
                          @RequestParam(value = "password", required = true) String password){

        if (StringUtils.isNoneEmpty(userName) && StringUtils.isNoneEmpty(password)) {
            if(Objects.nonNull(id)){
                AdminUser user = adminUserService.find(id);
                user.setUsername(StringUtils.trim(userName));
                user.setPassword(Md5Util.generatePassword(password));
                adminUserService.update(user);
            }else{
                AdminUser user = new AdminUser();
                user.setUsername(StringUtils.trim(userName));
                user.setPassword(Md5Util.generatePassword(password));
                adminUserService.save(user);
            }

            return "redirect:/backend/users";
        } else {
            return "backend/user_add";
        }

    }
}
