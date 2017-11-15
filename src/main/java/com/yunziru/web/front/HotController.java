package com.yunziru.web.front;

import com.yunziru.common.dto.AjaxResult;
import com.yunziru.movie.MovieConfig;
import com.yunziru.movie.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/hot")
public class HotController {

	@Resource
	private MovieService movieService;

	@RequestMapping("")
	public String hot(ModelMap modelMap){

		modelMap.put("movies", movieService.getHotMovieList(1, MovieConfig.HOT_DEFAULT_SIZE));
		modelMap.put("totalCount", movieService.getTotalCount());
		return "front/hot";
	}

	@RequestMapping(value = "movies/list", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public AjaxResult getMovieList(@RequestParam(defaultValue = "1", required = true) int page,
								   @RequestParam(defaultValue = "20", required = true) int size){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setData(this.movieService.getHotMovieList(page, size));
		ajaxResult.setSuccess(true);
		return ajaxResult;
	}

}
