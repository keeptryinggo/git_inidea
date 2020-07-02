package cn.liu.upload.web;

import cn.liu.upload.service.fdfsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("upload")
public class fdfsController {

    @Autowired
    private fdfsService fdfsS;
    @PostMapping("image")
    public String uploadImage(@RequestParam("file") MultipartFile file){
        return fdfsS.uploadImage(file);
    }
}
