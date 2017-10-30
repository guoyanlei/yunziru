package com.yunziru.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DetailController {
	
	@RequestMapping("/detail")
	public String login(){
		return "detail";
	}

}
