package wen.short_video.system.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wen.short_video.system.entity.UserHistory;
import wen.short_video.system.mapper.UserHistoryMapper;
import wen.short_video.system.service.UserHistoryService;

@Service
public class UserHistoryServiceImpl extends ServiceImpl<UserHistoryMapper, UserHistory> implements UserHistoryService {
}