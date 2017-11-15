package com.yunziru.web.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("backend/")
public class MovieController {

	@RequestMapping("movies")
	public String index(ModelMap modelMap){

		return "backend/movie_list";
	}

}
