package cn.liu.upload.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class fdfsService {
    @Autowired
    private FastFileStorageClient storageClient;

    public String uploadImage(MultipartFile file){
        try{
            String extension = StringUtils.substringAfterLast(file.getOriginalFilename(),".");
            StorePath storePath=storageClient.uploadFile(file.getInputStream(),file.getSize(),extension,null);
            return storePath.getFullPath();
        }catch(IOException e){
            throw new RuntimeException(e.getMessage());
        }

    }
}
