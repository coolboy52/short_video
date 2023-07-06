package wen.short_video.system.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wen.short_video.system.entity.TFlow;
import wen.short_video.system.mapper.TFlowMapper;
import wen.short_video.system.service.TFlowService;

@Service
public class TFlowServiceImpl extends ServiceImpl<TFlowMapper, TFlow> implements TFlowService {
}