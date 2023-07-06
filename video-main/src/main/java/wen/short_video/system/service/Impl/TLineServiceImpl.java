package wen.short_video.system.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wen.short_video.system.entity.TLine;
import wen.short_video.system.mapper.TLineMapper;
import wen.short_video.system.service.TLineService;

@Service
public class TLineServiceImpl extends ServiceImpl<TLineMapper, TLine> implements TLineService {
}