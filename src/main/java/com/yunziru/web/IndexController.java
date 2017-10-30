package com.yunziru.web;

import com.yunziru.movie.entity.Movie;
import com.yunziru.movie.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class IndexController {

	@Resource
	private MovieService movieService;

	@RequestMapping("/index")
	public String login(){
		Movie movie = movieService.find(1L);
		System.out.println(movie);
		return "index";
	}

}
