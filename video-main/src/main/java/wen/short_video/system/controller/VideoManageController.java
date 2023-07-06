package wen.short_video.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import wen.short_video.common.utils.Qiniuutil;
import wen.short_video.system.common.ResponseResult;
import wen.short_video.system.domain.dto.VideoUploadDto;
import wen.short_video.system.entity.Video;
import wen.short_video.system.entity.VideoComment;
import wen.short_video.system.mapper.VideoMapper;
import wen.short_video.system.service.VideoCommentService;
import wen.short_video.system.service.VideoService;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RequestMapping("/video")
@RestController
public class VideoManageController {


    @Autowired
    private Qiniuutil qiniuutil;

    @Autowired
    private VideoService videoService;



    @Resource
    private VideoCommentService videoCommentService;

    @PostMapping("/loadVideo")
    public ResponseResult<Video> loadVideo(@RequestParam("videoFile") MultipartFile VideoFile,@RequestParam("imageFile") MultipartFile imageFile, @RequestBody Video video) {
        String videPath="";
        String imagePath="";
        try {
            videPath = qiniuutil.saveFile(VideoFile);
            imagePath = qiniuutil.saveFile(imageFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
        String videoId = UUID.randomUUID().toString();
        video.setId(videoId);
        video.setVideoUrl(videPath);
        video.setCoverUrl(imagePath);
        video.setCommentCount("0");
        LocalDateTime currentTime = LocalDateTime.now();
        Date currentDate = new Date();
        video.setCreateTime(currentDate);
        videoService.save(video);

        return new ResponseResult(200, "视频上传成功");
    }

    /**
     * 瀑布流展示视频
     * @param videoNumber
     * @return
     */
    @PostMapping("/showVideo")
    public ResponseResult showVideo(@RequestParam Integer videoNumber){
        Page<Video> page=new Page<>(1,videoNumber);
        videoService.page(page);
        List<Video> video = videoService.getVideo();
        List<Video> videoId = videoService.getVideoId(1);
        return new ResponseResult(200,"请求成功", page);
    }


    /**
     * 删除视频
     * @param videoId
     * @return
     */
    public ResponseResult deleteVideo(@RequestParam Integer videoId){
        videoService.removeById(videoId);
        ResponseResult response= videoService.deleteVideo(videoId);

        return new ResponseResult(200,"删除成功");
    }








}
