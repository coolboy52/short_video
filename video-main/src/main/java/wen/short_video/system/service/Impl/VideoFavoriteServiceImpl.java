package wen.short_video.system.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wen.short_video.system.entity.VideoFavorite;
import wen.short_video.system.mapper.VideoFavoriteMapper;
import wen.short_video.system.service.VideoFavoriteService;

@Service
public class VideoFavoriteServiceImpl extends ServiceImpl<VideoFavoriteMapper, VideoFavorite> implements VideoFavoriteService {
}
