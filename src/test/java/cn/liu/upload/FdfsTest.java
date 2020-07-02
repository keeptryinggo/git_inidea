package cn.liu.upload;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FdfsTest {

    @Autowired
    private FastFileStorageClient storageClient;

    @Test
    public void testUpload() throws FileNotFoundException {
        File file = new File("D:\\lufei.jpg");
        StorePath storePath = storageClient.uploadFile(new FileInputStream(file),file.length(),"jpg",null);
        System.out.println(storePath.getFullPath());
        System.out.println(storePath.getPath());
    }
}
