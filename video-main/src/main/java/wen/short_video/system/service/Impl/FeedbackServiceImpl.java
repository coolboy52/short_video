package wen.short_video.system.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wen.short_video.system.entity.Feedback;
import wen.short_video.system.mapper.FeedbackMapper;
import wen.short_video.system.service.FeedbackService;

@Service
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements FeedbackService {
}