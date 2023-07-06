package wen.short_video.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import wen.short_video.system.common.ResponseResult;
import wen.short_video.system.entity.Video;

import java.util.List;

public interface VideoService extends IService<Video> {

    void saveVideo(Video video);

    Page<Video> showVideo(int videoNumber);


    ResponseResult deleteVideo(Integer videoId);

    List<Video> getVideoId(int id);

    List<Video> getVideo();
}
