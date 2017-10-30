package com.yunziru.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewController {
	
	@RequestMapping("/new")
	public String login(){
		return "new";
	}

}
