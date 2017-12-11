package com.yunziru.web.front;

import com.yunziru.cloud.resource.service.MenuService;
import com.yunziru.common.dto.AjaxResult;
import com.yunziru.movie.service.MovieService;
import com.yunziru.tag.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("movies")
public class DetailController {

	@Resource
	private MovieService movieService;

	@Resource
	private TagService tagService;

	@RequestMapping(value = "{id}/detail", method = RequestMethod.GET)
	public String getDetail(@PathVariable Long id,
							ModelMap modelMap){

		modelMap.put("ulikeMovies", movieService.getULikeMovie());
		modelMap.put("hotMovies", movieService.getRandomHotMovie());
		modelMap.put("movie", movieService.getMovieDetailInfo(id));
		modelMap.put("menus", MenuService.menusCache);
		return "front/detail";
	}

	@RequestMapping(value = "{id}/tagMovies", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public AjaxResult getTagMovies(@PathVariable Long id){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setData(tagService.getMovieTagStats(id));
		ajaxResult.setSuccess(true);
		return ajaxResult;
	}

	@RequestMapping(value = "{id}/hot", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public AjaxResult updateHotCount(@PathVariable Long id){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setData(this.movieService.updateHotCount(id));
		ajaxResult.setSuccess(true);
		return ajaxResult;
	}

	@RequestMapping(value = "{id}/prise", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public AjaxResult updatePriseCount(@PathVariable Long id){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setData(this.movieService.updatePriseCount(id));
		ajaxResult.setSuccess(true);
		return ajaxResult;
	}

}
