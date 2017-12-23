package com.yunziru.web.front.meiju;

import com.yunziru.cloud.resource.service.MenuService;
import com.yunziru.common.dto.AjaxResult;
import com.yunziru.meiju.service.MeiJuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("meijus")
public class MeiJuDetailController {

	@Resource
	private MeiJuService meiJuService;

	@RequestMapping(value = "{id}/detail", method = RequestMethod.GET)
	public String getDetail(@PathVariable Long id,
							ModelMap modelMap){

		modelMap.put("ulikeMeiJus", meiJuService.getULikeMeiJu());
		modelMap.put("hotMeiJus", meiJuService.getRandomHotMeiJu());
		modelMap.put("meiju", meiJuService.getMeiJuDetailInfo(id));
		modelMap.put("menus", MenuService.menusCache);
		return "front/meiju/meiju_detail";
	}

	@RequestMapping(value = "{id}/hot", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public AjaxResult updateHotCount(@PathVariable Long id){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setData(this.meiJuService.updateHotCount(id));
		ajaxResult.setSuccess(true);
		return ajaxResult;
	}

	@RequestMapping(value = "{id}/prise", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public AjaxResult updatePriseCount(@PathVariable Long id){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setData(this.meiJuService.updatePriseCount(id));
		ajaxResult.setSuccess(true);
		return ajaxResult;
	}

}
