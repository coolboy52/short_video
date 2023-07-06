package wen.short_video.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import wen.short_video.system.entity.Video;

import java.util.List;

@Mapper
public interface VideoMapper extends BaseMapper<Video> {

    @Select("select * from video")
    List<Video> getVideo();


    List<Video> getVideoId(int id);
}
