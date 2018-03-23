package com.ptteng.polyFinance.lgd.utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.GeneratePresignedUrlRequest;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

/**
 * @author lujing
 * Create_at 2018/3/17 9:54
 */
public class FilesUtil {
    
    private static final Logger logger = Logger.getLogger(FilesUtil.class);
    
    // 1 初始化用户身份信息(secretId, secretKey)
    static COSCredentials cred = new BasicCOSCredentials("AKID1wskR7t8MPI1kNuj9ayDH8nGcophKwHQ", "DID6pMkw9RL8mHepobGm6KPL5i9RvIWY");
    // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
    static ClientConfig clientConfig = new ClientConfig(new Region("ap-chengdu"));
    // 3 生成cos客户端
    static COSClient cosClient = new COSClient(cred, clientConfig);
    // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
    static String bucketName = "lujing0613-1255932852";
    
    //服务器根目录
    static String rootPATH = "https://lujing0613-1255932852.cos.ap-chengdu.myqcloud.com/";
    
    /**
     * @param picFile springmvc上传的图片流
     * @return 云储存路径（非访问路径）
     * @throws IOException
     */
    public static String upLoadFile(MultipartFile picFile) throws IOException {
        
        if (picFile != null) {
            InputStream inputStream = picFile.getInputStream();
            //获得文件的原始名字
            String originalFileName = picFile.getOriginalFilename();
            //新的文件名称=uuid+原始名字的后缀.xxx
            String newFlieName = UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."), originalFileName.length());
            //储存地址
            String key = "student/" + newFlieName;
            
            try {
                
                ObjectMetadata metadata = new ObjectMetadata();
                
                PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, inputStream, metadata);
                cosClient.putObject(putObjectRequest);
                
                logger.info("成功：上传地址：" + key);
                cosClient.shutdown();
                return key;
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("......图片上传失败");
            }
        }
        return null;
    }
    
    /**
     * @param file 普通的文件流
     * @return 云储存路径（非访问路径）
     * @throws IOException
     */
    public static String upLoadFile(File file) throws IOException {
        
        //获得文件的原始名字
        String originalFileName = file.getName();
        //新的文件名称=uuid+原始名字的后缀.xxx
        String newFlieName = UUID.randomUUID() + originalFileName.substring(originalFileName.indexOf("."));
        
        //储存地址
        String key = "student/" + newFlieName;
        
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file);
        cosClient.putObject(putObjectRequest);
        
        cosClient.shutdown();
        
        return key;
        
    }
    
    /**
     * @param FilePath 数据库储存路径
     * @throws CosServiceException
     */
    
    public static void deleteObject(String FilePath) throws CosServiceException {
//        //处理字符串,去掉  rootPATH
//        String cosPath = oldFilePath.replace(rootPATH, "");
        if (CommonUtil.isEmpty(FilePath)) {
            return;
        }
        cosClient.deleteObject(bucketName, FilePath);
        cosClient.shutdown();
    }
    
    public static String getUrl(String FilePath) {
        //处理字符串,去掉  rootPATH
//        String cosPath = oldFilePath.replace(rootPATH, "");
        if (CommonUtil.isEmpty(FilePath)) {
            return "";
        }
        String key = FilePath;
        GeneratePresignedUrlRequest req =
                new GeneratePresignedUrlRequest(bucketName, key, HttpMethodName.GET);
        
        Date expirationDate = new Date(System.currentTimeMillis() + 30 * 60 * 1000);
        req.setExpiration(expirationDate);
        URL downloadUrl = cosClient.generatePresignedUrl(req);
        String downloadUrlStr = downloadUrl.toString();
        
        return downloadUrlStr;
    }
    
    public static void main(String[] args) {
        System.out.println(getUrl("student/e4fdc694-eb57-40a5-a363-1d63595d491a.jpg"));
    }
    
}
