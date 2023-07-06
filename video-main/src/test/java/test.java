import org.apache.commons.compress.utils.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import wen.short_video.common.utils.Qiniuutil;
import wen.short_video.system.entity.Video;
import wen.short_video.system.mapper.VideoMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class test {

    @Autowired
    private VideoMapper videoMapper;
    Qiniuutil qiniuutil = new Qiniuutil();
    public static void main(String[] args) {

    }

    @Test
    public void test1() throws IOException {


//        //准备测试数据
        String fileName = "D:\\图片\\web_atlas.jpg";
        File file = new File(fileName);
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", fileName, "image/jpeg", new FileInputStream(file));
//        File file = new File("D:\\图片\\web_atlas.jpg");  // 文件路径
//        FileInputStream input = new FileInputStream(file);
//// File 转 MultipartFile
//        MultipartFile targetFiles = new MockMultipartFile("targetFiles",file.getName(),null, IOUtils.toByteArray(input));
        String s = qiniuutil.saveFile(mockMultipartFile);
        System.out.println(s);
    }

    @Test
    public void time(){
        Date currentDate = new Date();

        System.out.println(currentDate);
    }


    @Test
    public void state(){
        qiniuutil.state("short-viedo123456","short-video/video/下载 - 2022-10-14T223652.193.mp4");
    }

    @Test
    public void videoList(){
        List<Video> video = videoMapper.getVideo();
        System.out.println(video);
    }


}
