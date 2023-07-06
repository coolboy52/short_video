package wen.short_video.system.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import wen.short_video.system.entity.Video;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoUploadDto {
    //上传的文件
    private MultipartFile file;

    //上传的视频信息
    private Video video;
}
