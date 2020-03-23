package cn.tedu.img.service;

import com.jt.common.utils.UploadUtil;
import com.jt.common.vo.PicUploadResult;
import javafx.scene.input.PickResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class ImgService {

    public PicUploadResult picUp(MultipartFile pic) {
        PicUploadResult result = new PicUploadResult();
        /*
            1.判断pic是否合法 通过后缀.jpg .png

            2.生成一个公用路径 工具类 UploadUtil
            存储路径 D:/img/upload/2/d/3/d/3/d/3/d/图片.img;
            url路径:http://image.jt.com/upload/2/d/3/d/3/d/3/d/图片.img;

            3.拼接存储路径 重命名文件 输出图片到文件夹
            4.拼接url地址封装到对象数据返回
        */

        //获取文件名称，解析后缀值
        String oName = pic.getOriginalFilename();   //获取文件原名称
        String extName = oName.substring(oName.lastIndexOf("."));
        if(!extName.matches(".(jpg|png|gif|jpeg)$")){
            result.setError(1);
            return result;
        }
        //后缀合法
        String path = UploadUtil.getUploadPath(oName,"upload");

        String dir = "d://img"+path+"/";    //d://img/upload/2/d/3/...
        //有则用 没有则创建
        File _dir = new File(dir);
        if(!_dir.exists()){
            _dir.mkdirs();
        }
        String newName = UUID.randomUUID().toString()+extName;
        try {
            pic.transferTo(new File(dir+newName));
        } catch (IOException e) {
            e.printStackTrace();
            result.setError(1);
            return result;
        }

        //拼接上可以访问到这个图片的url路径
        String url = "http://image.jt.com/"+path+"/"+newName;
        result.setUrl(url);
        return result;
    }
}































