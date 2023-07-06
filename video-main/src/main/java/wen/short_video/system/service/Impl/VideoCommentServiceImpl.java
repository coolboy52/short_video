package wen.short_video.system.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wen.short_video.system.entity.VideoComment;
import wen.short_video.system.mapper.VideoCommentMapper;
import wen.short_video.system.service.VideoCommentService;

@Service
public class VideoCommentServiceImpl extends ServiceImpl<VideoCommentMapper, VideoComment> implements VideoCommentService {
}
