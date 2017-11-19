package com.yunziru.web.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("backend/")
public class SignUpController {

	@RequestMapping("sign")
	public String index(ModelMap modelMap){

		return "backend/sign_up";
	}

}
