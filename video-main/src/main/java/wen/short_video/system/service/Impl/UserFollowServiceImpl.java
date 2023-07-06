package wen.short_video.system.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wen.short_video.system.entity.UserFollow;
import wen.short_video.system.mapper.UserFollowMapper;
import wen.short_video.system.service.UserFollowService;

@Service
public class UserFollowServiceImpl extends ServiceImpl<UserFollowMapper, UserFollow> implements UserFollowService {
}