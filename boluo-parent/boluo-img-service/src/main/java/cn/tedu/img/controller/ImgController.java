package cn.tedu.img.controller;

import cn.tedu.img.service.ImgService;
import com.jt.common.vo.PicUploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImgController {
    @Autowired
    private ImgService is;

    //图片上传
    @RequestMapping("pic/uploadImg")
    public PicUploadResult picip(MultipartFile pic){
        System.out.println("上传图片微服务");
        return is.picUp(pic);
    }

    @RequestMapping("test")
    public void test(){
        System.out.println("上传图片微服_测试");
    }

}
