package wen.short_video.system.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wen.short_video.system.entity.VideoReport;
import wen.short_video.system.mapper.VideoReportMapper;
import wen.short_video.system.service.VideoReportService;

@Service
public class VideoReportServiceImpl extends ServiceImpl<VideoReportMapper, VideoReport> implements VideoReportService {
}


