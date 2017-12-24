package com.yunziru.web.front.meiju;

import com.yunziru.cloud.resource.service.MenuService;
import com.yunziru.common.dto.AjaxResult;
import com.yunziru.meiju.MeiJuConfig;
import com.yunziru.meiju.service.MeiJuService;
import com.yunziru.movie.MovieConfig;
import com.yunziru.movie.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/meijus")
public class MeiJuHotUpdateController {

	@Resource
	private MeiJuService meiJuService;

	@Resource
	private MovieService movieService;

	@RequestMapping("{category}/hot")
	public String hot(@PathVariable String category,
					  ModelMap modelMap){

		modelMap.put("meijus", meiJuService.getHotUpdateMeiJuList(category, 1, MeiJuConfig.HOT_DEFAULT_SIZE));
		modelMap.put("totalCount", movieService.getTotalCount());
		modelMap.put("menus", MenuService.menusCache);
        modelMap.put("category", category);
        modelMap.put("categoryCH", MenuService.getNameByUrl(category));
		return "front/meiju/meiju_hot";
	}

	@RequestMapping(value = "{category}/hot/list", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public AjaxResult getMovieList(@PathVariable String category,
								   @RequestParam(defaultValue = "1", required = true) int page,
								   @RequestParam(defaultValue = "20", required = true) int size){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setData(this.meiJuService.getHotUpdateMeiJuList(category, page, size));
		ajaxResult.setSuccess(true);
		return ajaxResult;
	}

}
