package wen.short_video.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import wen.short_video.system.entity.VideoComment;

@Mapper
public interface VideoCommentMapper extends BaseMapper<VideoComment> {
}
