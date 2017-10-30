package com.yunziru.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotController {
	
	@RequestMapping("/hot")
	public String login(){
		return "hot";
	}

}
