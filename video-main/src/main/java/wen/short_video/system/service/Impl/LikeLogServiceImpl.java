package wen.short_video.system.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wen.short_video.system.entity.LikeLog;
import wen.short_video.system.mapper.LikeLogMapper;
import wen.short_video.system.service.LikeLogService;

@Service
public class LikeLogServiceImpl extends ServiceImpl<LikeLogMapper, LikeLog> implements LikeLogService {
}