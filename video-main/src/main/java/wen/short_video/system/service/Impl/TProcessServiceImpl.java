package wen.short_video.system.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wen.short_video.system.entity.TProcess;
import wen.short_video.system.mapper.TProcessMapper;
import wen.short_video.system.service.TProcessService;

@Service
public class TProcessServiceImpl extends ServiceImpl<TProcessMapper, TProcess> implements TProcessService {
}