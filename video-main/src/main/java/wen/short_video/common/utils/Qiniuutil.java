package wen.short_video.common.utils;

import com.qiniu.common.Zone;
//import com.qiniu.util.Auth;
//import net.dreamlu.mica.core.utils.FileUtil;
//import org.mybatis.logging.Logger;
//import org.mybatis.logging.LoggerFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Service;
//import com.qiniu.common.QiniuException;
//import com.qiniu.http.Response;
//import com.qiniu.storage.UploadManager;
//import com.squareup.okhttp.OkHttpClient;
//import com.squareup.okhttp.Request;
//import com.squareup.okhttp.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
import com.qiniu.storage.Region;
import com.qiniu.util.StringMap;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.model.FileInfo;
//import com.qiniu.common.Region;

import com.alibaba.fastjson.JSONObject;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.UUID;
import com.qiniu.util.Auth;
import java.io.*;
import java.util.UUID;


@Component
public class Qiniuutil {

    private static final Logger logger = LoggerFactory.getLogger(Qiniuutil.class);

    // 设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = "BjaeRKkYvw1fKUlXrusf0LEOY2dRjPhQjLyn5KFe";
    String SECRET_KEY = "TSWC7RPAmEk_SSKH7AC8wPdVAwkrC4bJBvl7XO9M";
    // 要上传的空间
    String bucketname = "short-viedo123456";

    // 密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    // 构造一个带指定Zone对象的配置类,不同的七云牛存储区域调用不同的zone
    Configuration cfg = new Configuration();
    // ...其他参数参考类注释
    UploadManager uploadManager = new UploadManager(cfg);

    // 测试域名，只有30天有效期
    private static String QINIU_IMAGE_DOMAIN = "http://rwbun9ee5.hn-bkt.clouddn.com/";

    // 简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken() {
        return auth.uploadToken(bucketname);
    }

    public String saveFile(MultipartFile file) throws IOException {
        try {
            int dotPos = file.getOriginalFilename().lastIndexOf(".");
            if (dotPos < 0) {
                return null;
            }
            String fileExt = file.getOriginalFilename().substring(dotPos + 1).toLowerCase();
            // 判断是否是合法的文件后缀
//            if (!FileUtil.isFileAllowed(fileExt)) {
//                return null;
//            }

            String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + fileExt;
            // 调用put方法上传
            Response res = uploadManager.put(file.getBytes(), fileName, getUpToken());
            // 打印返回的信息
            if (res.isOK() && res.isJson()) {
                // 返回文件的地址
                return QINIU_IMAGE_DOMAIN + JSONObject.parseObject(res.bodyString()).get("key");
            } else {
                logger.error("七牛异常:" + res.bodyString());
                return null;
            }
        } catch (QiniuException e) {
            // 请求失败时打印的异常的信息
            logger.error("七牛异常:" + e.getMessage());
            return null;
        }
    }

    /**
     *获取文件信息
     * @param fileKey 文件路径
     */
    public void state(String bucketName,String fileKey){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region2());
//...其他参数参考类注释

        String accessKey = "BjaeRKkYvw1fKUlXrusf0LEOY2dRjPhQjLyn5KFe";
        String secretKey = "TSWC7RPAmEk_SSKH7AC8wPdVAwkrC4bJBvl7XO9M";
        String bucket = bucketName;
        String key = fileKey;

        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            FileInfo fileInfo = bucketManager.stat(bucket, key);
            String publicUrl = auth.privateDownloadUrl(bucketName + "/" + fileKey);
            System.out.println(publicUrl);
            System.out.println(fileInfo.hash);
            System.out.println(fileInfo.fsize);
            System.out.println(fileInfo.mimeType);
            System.out.println(fileInfo.putTime);
        } catch (QiniuException ex) {
            System.err.println(ex.response.toString());
        }

    }



}
