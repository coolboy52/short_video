package wen.short_video.system.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wen.short_video.system.entity.User;
import wen.short_video.system.mapper.UserMapper;
import wen.short_video.system.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
