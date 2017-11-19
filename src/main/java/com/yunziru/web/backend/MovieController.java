package com.yunziru.web.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("backend/")
public class MovieController {

	@RequestMapping("movies")
	public String index(ModelMap modelMap){

		modelMap.put("sub_active_menu","movie_list");
		modelMap.put("active_menu","movies");
		return "backend/movie_list";
	}

}
