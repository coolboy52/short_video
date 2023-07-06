package wen.short_video.system.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wen.short_video.system.common.ResponseResult;
import wen.short_video.system.entity.VideoComment;

@RequestMapping("/comm")
public class CommentController {

    @PostMapping("/show")
    public ResponseResult<VideoComment> showComment(){
        




        return new ResponseResult<>(200,"查询成功");
    }




}
