package com.yunziru.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreshController {
	
	@RequestMapping("/fresh")
	public String login(){
		return "fresh";
	}

}
