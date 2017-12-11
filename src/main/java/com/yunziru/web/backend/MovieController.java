package com.yunziru.web.backend;

import com.yunziru.common.dto.AjaxResult;
import com.yunziru.movie.dto.MovieRBodyDTO;
import com.yunziru.movie.entity.RecommendMovie;
import com.yunziru.movie.service.MovieService;
import com.yunziru.movie.service.RecommendMovieService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
        modelMap.put("keyword", keyword);

        modelMap.put("movies", movieService.findAllByPage(page, size, time, keyword));
        return "backend/movie_list";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(ModelMap modelMap){

        return "backend/movie_add";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String edit(@RequestParam(value = "id", required = true)  Long id,
                       ModelMap modelMap){
        modelMap.put("movie", movieService.getMovieRBody(id));
        return "backend/movie_add";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addMovie(HttpServletRequest request,
                           ModelMap modelMap) throws UnsupportedEncodingException {

        request.setCharacterEncoding("utf-8");

        Long id = null;
        if (StringUtils.isNoneEmpty(request.getParameter("id"))) {
            id = NumberUtils.parseNumber(request.getParameter("id"), Long.class);
        }
        String title = new String(request.getParameter("title").getBytes("iso8859-1"), "UTF-8");
        String name = new String(request.getParameter("name").getBytes("iso8859-1"), "UTF-8");
        Integer year = NumberUtils.parseNumber(request.getParameter("year"), Integer.class);
        String location = new String(request.getParameter("location").getBytes("iso8859-1"), "UTF-8");
        String type = new String(request.getParameter("type").getBytes("iso8859-1"), "UTF-8");
        String ed2kLink = new String(request.getParameter("ed2kLink").getBytes("iso8859-1"), "UTF-8");
        String baiduLink = new String(request.getParameter("baiduLink").getBytes("iso8859-1"), "UTF-8");
        String baiduPwd = new String(request.getParameter("baiduPwd").getBytes("iso8859-1"), "UTF-8");
        Integer tid = NumberUtils.parseNumber(request.getParameter("tid"), Integer.class);
        String summary = new String(request.getParameter("summary").getBytes("iso8859-1"), "UTF-8");
        String images = new String(request.getParameter("images").getBytes("iso8859-1"), "UTF-8");

        movieService.addMovie(id,title,name,year,location,type,ed2kLink,baiduLink,baiduPwd,tid,summary,images);

        return "redirect:/backend/movies";
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
