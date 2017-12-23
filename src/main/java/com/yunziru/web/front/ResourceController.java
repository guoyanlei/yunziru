package com.yunziru.web.front;

import com.yunziru.cloud.resource.CloudResourceConfig;
import com.yunziru.cloud.resource.service.CloudResourceService;
import com.yunziru.cloud.resource.service.MenuService;
import com.yunziru.common.dto.AjaxResult;
import com.yunziru.movie.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by guoyanlei
 * Date：2017/12/10
 * Description：云资源Controller
 */
@Controller
@RequestMapping("")
public class ResourceController {

    @Resource
    private CloudResourceService cloudResourceService;

    @Resource
    private MovieService movieService;

    @RequestMapping("/{menu}")
    public String resources(@PathVariable String menu,
                        ModelMap modelMap){

        modelMap.put("resources", cloudResourceService.getResourceList(null, 1, CloudResourceConfig.RESOURCE_DEFAULT_SIZE, menu));
        modelMap.put("totalCount", movieService.getTotalCount());
        modelMap.put("menus", MenuService.menusCache);
        modelMap.put("menuName", menu);
        return "front/resource";
    }

    @RequestMapping(value = "{menu}/list", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public AjaxResult getResourceList(@PathVariable String menu,
                                      @RequestParam(value = "keyword", required = false) String keyword,
                                      @RequestParam(defaultValue = "1", required = true) int page,
                                      @RequestParam(defaultValue = "20", required = true) int size) {

        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setData(this.cloudResourceService.getResourceList(keyword, page, size, menu));
        ajaxResult.setSuccess(true);
        return ajaxResult;
    }
}
