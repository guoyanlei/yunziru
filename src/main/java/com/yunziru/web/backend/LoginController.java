package com.yunziru.web.backend;

import com.yunziru.common.util.Md5Util;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("backend/")
public class LoginController {

	@RequestMapping("login")
	public String index(ModelMap modelMap){

		return "backend/login";
	}

	@RequestMapping(value = "do_login", method = RequestMethod.POST)
	public String userList(@RequestParam(value = "username", required = true) String username,
						   @RequestParam(value = "password", required = true) String password,
						   @RequestParam(value = "rememberMe", required = false) String rememberMe,
						   ModelMap modelMap){

        try {

            String md5Pwd = Md5Util.generatePassword(password);
            boolean remember = StringUtils.isNotEmpty(rememberMe) && rememberMe.equals("on");

            UsernamePasswordToken token = new UsernamePasswordToken(username, md5Pwd, remember);

            Subject subject = SecurityUtils.getSubject();

            subject.login(token);

            return "redirect:/backend/users";

        } catch (LockedAccountException lae) {
            modelMap.addAttribute("msg", "账号已被禁用");
            return "backend/login";
        } catch (AuthenticationException ae) {
            modelMap.addAttribute("msg", "账号或密码错误");
            return "backend/login";
        } catch (Exception e) {
            modelMap.addAttribute("msg", "登录异常");
            return "backend/login";
        }
	}

    @RequestMapping("login_out")
    public String loginOut(){

        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        return "redirect:login";
    }

}
