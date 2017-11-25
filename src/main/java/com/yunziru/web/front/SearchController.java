package com.yunziru.web.front;

import com.yunziru.movie.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class SearchController {

	@Resource
	private MovieService movieService;

	@RequestMapping("/search")
	public String search(ModelMap modelMap){

		modelMap.put("ulikeMovies", movieService.getULikeMovie());
		return "front/search";
	}

}
