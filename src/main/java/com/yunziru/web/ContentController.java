package com.yunziru.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentController {
	
	@RequestMapping("/content")
	public String login(){
		return "content";
	}

}
