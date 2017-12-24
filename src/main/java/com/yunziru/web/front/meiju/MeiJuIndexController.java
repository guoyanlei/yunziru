package com.yunziru.web.front.meiju;

import com.yunziru.cloud.resource.service.MenuService;
import com.yunziru.common.dto.AjaxResult;
import com.yunziru.meiju.MeiJuConfig;
import com.yunziru.meiju.service.MeiJuService;
import com.yunziru.movie.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("meijus")
public class MeiJuIndexController {

	@Resource
	private MeiJuService meiJuService;

    @Resource
    private MovieService movieService;

	@RequestMapping("{category}")
	public String index(@PathVariable String category,
						ModelMap modelMap){

		modelMap.put("meijus", meiJuService.getIndexMeiJuList(null, category, 1, MeiJuConfig.INDEX_DEFAULT_SIZE));
		modelMap.put("totalCount", movieService.getTotalCount());
        modelMap.put("menus", MenuService.menusCache);
        modelMap.put("category", category);
        modelMap.put("categoryCH", MenuService.getNameByUrl(category));
		return "front/meiju/meiju_index";
	}

	@RequestMapping(value = "{category}/list", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public AjaxResult getMeiJuList(@PathVariable String category,
                                   @RequestParam(value = "keyword", required = false) String keyword,
								   @RequestParam(defaultValue = "1", required = true) int page,
								   @RequestParam(defaultValue = "20", required = true) int size) {

		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setData(this.meiJuService.getIndexMeiJuList(keyword, category, page, size));
		ajaxResult.setSuccess(true);
		return ajaxResult;
	}

	@RequestMapping(value = "list", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public AjaxResult getMeiJuList(@RequestParam(value = "keyword", required = false) String keyword,
								   @RequestParam(defaultValue = "1", required = true) int page,
								   @RequestParam(defaultValue = "20", required = true) int size) {

		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setData(this.meiJuService.getIndexMeiJuList(keyword, null, page, size));
		ajaxResult.setSuccess(true);
		return ajaxResult;
	}

}
