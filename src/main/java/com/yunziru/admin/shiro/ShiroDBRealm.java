package com.yunziru.admin.shiro;

import com.yunziru.admin.Service.AdminUserService;
import com.yunziru.admin.entity.AdminUser;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroDBRealm extends AuthorizingRealm{

	public static final String SESSION_LOGIN_USER = "session_login_user";


	@Autowired
	private AdminUserService adminUserService;


	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		return null;
	}

	/**
	 * 验证当前用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

		UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;

		if(StringUtils.isEmpty(token.getUsername())){
			return null;
		}

		AdminUser user = adminUserService.findUserByName(token.getUsername());
		if(user != null){

			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());

			Subject subject = SecurityUtils.getSubject();
			if(subject != null){
				Session session = subject.getSession();
				if(session != null){
					session.setAttribute(SESSION_LOGIN_USER, user);
				}
			}

			return authcInfo;
		}
		return null;
	}
}
