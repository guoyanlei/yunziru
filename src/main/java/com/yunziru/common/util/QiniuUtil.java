package com.yunziru.common.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by guoyanlei
 * Date：2017/11/1
 * Description：
 */
public class QiniuUtil {

    private static Logger logger = Logger.getLogger(QiniuUtil.class);

    public static String storeMovieImage(InputStream inputStream, String fileName) {
        return storeQiniuAndGetUrlByInputStream(QiniuConf.MOVIE_FOlDER, inputStream, fileName);
    }

    public static String storeMovieImage(String imgUrl) {
        return storeQiniuAndGetUrlByImgUrl(QiniuConf.MOVIE_FOlDER, imgUrl);
    }


    /**
     * 读取inputStream并将图片存储到七牛云
     * @param folder 文件夹路径
     * @param inputStream 上传文件的inputStream
     * @param fileName 文件名
     * @return 返回七牛云存储后的图片url
     */
    public static String storeQiniuAndGetUrlByInputStream(String folder, InputStream inputStream, String fileName) {

        Configuration cfg = new Configuration(Zone.zone1());
        UploadManager uploadManager = new UploadManager(cfg);

        String key = folder + "/" + fileName;
        Auth auth = Auth.create(QiniuConf.accessKey, QiniuConf.secretKey);
        String upToken = auth.uploadToken(QiniuConf.bucket);

        try {

            Response response = uploadManager.put(inputStream, key, upToken, null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

            //System.out.println(putRet.hash);
            return QiniuConf.domain + putRet.key;

        } catch (QiniuException ex) {
            logger.warn("qiuniu upload error ", ex);
            Response r = ex.response;
            logger.warn(r.toString());
        }
        return "";
    }


    /**
     * 请求http图片url，并获取图片byte[]，存放到七牛云
     * @param folder 七牛云上面的文件夹
     * @param imgUrl http图片url
     * @return 返回七牛云存储后的图片url
     */
    public static String storeQiniuAndGetUrlByImgUrl(String folder, String imgUrl) {

        Configuration cfg = new Configuration(Zone.zone1());

        UploadManager uploadManager = new UploadManager(cfg);

        String key = folder + "/" + getFileName(imgUrl);

        Auth auth = Auth.create(QiniuConf.accessKey, QiniuConf.secretKey);
        String upToken = auth.uploadToken(QiniuConf.bucket);

        try {

            CloseableHttpClient httpClient = HttpClients.createDefault();

            HttpGet httpGet = new HttpGet(imgUrl);
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
            // 执行请求
            HttpResponse httpResponse = httpClient.execute(httpGet);

            if(httpResponse.getStatusLine().getStatusCode() == 200){

                //得到实体
                HttpEntity entity = httpResponse.getEntity();

                byte[] data = EntityUtils.toByteArray(entity);

                Response response = uploadManager.put(data, key, upToken);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

                //System.out.println(putRet.hash);
                return QiniuConf.domain + putRet.key;
            }

        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getFileName(String imgUrl) {
        String[] files = imgUrl.split("/");
        return files[files.length-1];
    }
}
