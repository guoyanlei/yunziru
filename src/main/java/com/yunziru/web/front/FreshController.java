package com.yunziru.web.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreshController {
	
	@RequestMapping("/fresh")
	public String login(){
		return "front/fresh";
	}

}
