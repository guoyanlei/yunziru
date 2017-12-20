package com.yunziru.web.front.meiju;

import com.yunziru.cloud.resource.service.MenuService;
import com.yunziru.common.dto.AjaxResult;
import com.yunziru.meiju.MeiJuConfig;
import com.yunziru.meiju.service.MeiJuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("meijus")
public class MeiJuIndexController {

	@Resource
	private MeiJuService meiJuService;

	@RequestMapping("")
	public String index(ModelMap modelMap){

		modelMap.put("meijus", meiJuService.getIndexMeiJuList(null, 1, MeiJuConfig.INDEX_DEFAULT_SIZE));
		modelMap.put("totalCount", meiJuService.getTotalCount());
        modelMap.put("menus", MenuService.menusCache);
		return "front/meiju/meiju_index";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public AjaxResult getMeiJuList(@RequestParam(value = "keyword", required = false) String keyword,
								   @RequestParam(defaultValue = "1", required = true) int page,
								   @RequestParam(defaultValue = "20", required = true) int size) {

		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setData(this.meiJuService.getIndexMeiJuList(keyword, page, size));
		ajaxResult.setSuccess(true);
		return ajaxResult;
	}

}
