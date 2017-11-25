package com.yunziru.web.backend;

import com.yunziru.common.dto.AjaxResult;
import com.yunziru.movie.entity.RecommendMovie;
import com.yunziru.movie.service.MovieService;
import com.yunziru.movie.service.RecommendMovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("backend/movies")
public class MovieController {

    @Resource
    private MovieService movieService;

    @Resource
    private RecommendMovieService recommendMovieService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String movies(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
                         @RequestParam(value = "size", defaultValue = "20", required = false) int size,
                         @RequestParam(value = "time", required = false) String time,
                         @RequestParam(value = "keyword", required = false) String keyword,
                         ModelMap modelMap) throws UnsupportedEncodingException {

        //添加菜单显示
        modelMap.put("active_menu", "movies");
        modelMap.put("active_menu_display", "movies_ul");
        modelMap.put("sub_active_menu", "movie_list");

        //搜索参数
        modelMap.put("time", time);

        String str = null;
        if (keyword != null) {
            str = new String(keyword.getBytes("iso8859-1"), "UTF-8");
            modelMap.put("keyword", str);
        }
        modelMap.put("movies", movieService.findAllByPage(page, size, time, str));
        return "backend/movie_list";
    }

    @RequestMapping(value = "recommend", method = RequestMethod.GET)
    public String recommend(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
                            @RequestParam(value = "size", defaultValue = "20", required = false) int size,
                            @RequestParam(value = "time", required = false) String time,
                            ModelMap modelMap) throws UnsupportedEncodingException {

        //添加菜单显示
        modelMap.put("active_menu", "movies");
        modelMap.put("active_menu_display", "movies_ul");
        modelMap.put("sub_active_menu", "recommend_movies");

        //搜索参数
        modelMap.put("time", time);

        modelMap.put("movies", recommendMovieService.findAllByPage(page, size, time));
        return "backend/recommend_movies";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public AjaxResult deleteMovie(@PathVariable(value = "id") Long id,
                                  ModelMap modelMap) {

        AjaxResult ajaxResult = new AjaxResult();
        movieService.deleteMovie(id);
        ajaxResult.setData(true);
        ajaxResult.setSuccess(true);
        return ajaxResult;
    }

    @RequestMapping(value = "recommend", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult addRecommend(@RequestParam(value = "movieId", required = true) Long movieId,
                                   ModelMap modelMap) {

        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setData(recommendMovieService.addRecommend(movieId));
        ajaxResult.setSuccess(true);
        return ajaxResult;
    }

    @RequestMapping(value = "recommend/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public AjaxResult deleteRecommend(@PathVariable(value = "id") Long movieId,
                                   ModelMap modelMap) {

        AjaxResult ajaxResult = new AjaxResult();
        recommendMovieService.deleteRecommend(movieId);
        ajaxResult.setData(true);
        ajaxResult.setSuccess(true);
        return ajaxResult;
    }

}
