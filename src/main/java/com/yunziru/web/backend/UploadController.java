package com.yunziru.web.backend;

import com.alibaba.fastjson.JSONObject;
import com.yunziru.common.dto.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

@Controller
@RequestMapping("backend/")
public class UploadController {

	@RequestMapping("fileUpload")
    @ResponseBody
	public AjaxResult fileUpload(@RequestParam("file") MultipartFile fileUpload,
                                 HttpServletRequest request,
                                 HttpServletResponse response,
                                 ModelMap modelMap) throws IOException {

		SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMddhhmmss" );
		String fileName = sFormat.format(Calendar.getInstance().getTime())+ new Random().nextInt(1000);
		String originalFilename = fileUpload.getOriginalFilename();
		fileName += originalFilename.substring(originalFilename.lastIndexOf("." ));
		String dirName = request.getSession().getServletContext().getRealPath("/" )+"fileUpload" ;

        System.out.println(fileName);
        System.out.println(dirName);

		double originalFilesize = request.getContentLength();//获取源文件大小

        System.out.println(originalFilesize);
        AjaxResult result = new AjaxResult();
        result.setSuccess(true);
        result.setData(dirName);
        result.setMsg("上传成功");
        return result;
	}

}
