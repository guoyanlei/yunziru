package com.yunziru.web;

import com.yunziru.movie.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
@RequestMapping("movies")
public class DetailController {

	@Resource
	private MovieService movieService;

	@RequestMapping(value = "{id}/detail", method = RequestMethod.GET)
	public String getDetail(@PathVariable Long id,
							ModelMap modelMap){

		modelMap.put("hotMovies", movieService.getRandomHotMovie());
		modelMap.put("movie", movieService.getMovieDetailInfo(id));
		return "detail";
	}

}
