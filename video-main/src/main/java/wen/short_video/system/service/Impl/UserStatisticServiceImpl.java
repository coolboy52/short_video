package wen.short_video.system.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wen.short_video.system.entity.UserStatistic;
import wen.short_video.system.mapper.UserStatisticMapper;
import wen.short_video.system.service.UserStatisticService;

@Service
public class UserStatisticServiceImpl extends ServiceImpl<UserStatisticMapper, UserStatistic> implements UserStatisticService {
}