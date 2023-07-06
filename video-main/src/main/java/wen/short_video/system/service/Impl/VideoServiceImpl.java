package wen.short_video.system.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wen.short_video.common.utils.DateUtil;
import wen.short_video.system.common.ResponseResult;
import wen.short_video.system.entity.LikeLog;
import wen.short_video.system.entity.Video;
import wen.short_video.system.entity.VideoComment;
import wen.short_video.system.entity.VideoReport;
import wen.short_video.system.mapper.VideoMapper;
import wen.short_video.system.service.LikeLogService;
import wen.short_video.system.service.VideoCommentService;
import wen.short_video.system.service.VideoService;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

//    @Autowired
//    private VideoService videoService;

    @Resource
    private VideoMapper videoMapper;
    @Autowired
    private VideoCommentService videoCommentService;

    @Autowired
    private LikeLogService likeLogService;


    @Override
    public void saveVideo(Video video) {
//        video.setComment_count(0);
//        LocalDateTime currentTime = LocalDateTime.now();
//        Date currentDate = new Date();
//        video.setCreate_time(currentDate);
//        videoService.save(video);


    }

    @Override
    public Page<Video> showVideo(int videoNumber) {
//        LambdaQueryWrapper<Video> lambdaQueryWrapper=new LambdaQueryWrapper();
//        lambdaQueryWrapper.isNotNull(Video::getId);
//        Page<Video> page=new Page<>(videoNumber,videoNumber);
//        videoService.page(page, lambdaQueryWrapper);
//

        return null;
    }

    public List<Video> getVideoId(int id){
      return   videoMapper.getVideoId(id);
    }

    @Override
    public List<Video> getVideo() {
        List<Video> video = videoMapper.getVideo();
        return video;
    }

    /**
     * 删除视频
     * @param videoId
     * @return
     */
    @Override
    public ResponseResult deleteVideo(Integer videoId) {
        LambdaQueryWrapper<VideoComment> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(VideoComment::getVideoId,videoId);
        videoCommentService.remove(queryWrapper);
        LambdaUpdateWrapper<LikeLog> wrapper=new LambdaUpdateWrapper<>();
        wrapper.eq(LikeLog::getVideoId,videoId);
        likeLogService.remove(wrapper);

        return new ResponseResult(200,"删除成功");
    }


}
