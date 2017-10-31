package com.yunziru.web;

import com.yunziru.common.dto.AjaxResult;
import com.yunziru.movie.entity.Movie;
import com.yunziru.movie.service.MovieService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("")
public class IndexController {

	@Resource
	private MovieService movieService;

	@RequestMapping("/index")
	public String login(ModelMap modelMap){
		return "index";
	}

	@RequestMapping(value = "movies/list", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public AjaxResult getMovieList(@RequestParam(defaultValue = "1", required = true) int page,
								   @RequestParam(defaultValue = "20", required = true) int size,
								   ModelMap modelMap){
		AjaxResult ajaxResult = new AjaxResult();
		PageRequest pageRequest = new PageRequest(page, size);
		Page<Movie> movies = this.movieService.findAll(pageRequest);
		ajaxResult.setData(movies);
		ajaxResult.setSuccess(true);
		return ajaxResult;
	}

}
