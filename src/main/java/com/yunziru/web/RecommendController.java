package com.yunziru.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecommendController {
	
	@RequestMapping("/recommend")
	public String login(){
		return "recommend";
	}

}
