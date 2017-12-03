package com.yunziru.web.backend;

import com.yunziru.common.dto.AjaxResult;
import com.yunziru.common.util.QiniuUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

@Controller
@RequestMapping("backend/")
public class UploadController {

	@RequestMapping("fileUpload")
    @ResponseBody
	public AjaxResult fileUpload(@RequestParam("file") MultipartFile fileUpload) throws IOException {

		SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMddhhmmss" );
		String fileName = sFormat.format(Calendar.getInstance().getTime())+ new Random().nextInt(1000);
		String originalFilename = fileUpload.getOriginalFilename();
		fileName += originalFilename.substring(originalFilename.lastIndexOf("." ));

        String imgUrl = QiniuUtil.storeMovieImage(fileUpload.getInputStream(), fileName);

        AjaxResult result = new AjaxResult();
        result.setSuccess(true);
        result.setData(imgUrl);
        result.setMsg("上传成功");
        return result;
	}

}
