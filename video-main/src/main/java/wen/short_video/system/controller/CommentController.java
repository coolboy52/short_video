package wen.short_video.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import wen.short_video.system.common.ResponseResult;
import wen.short_video.system.domain.vo.PageVo;
import wen.short_video.system.entity.VideoComment;
import wen.short_video.system.service.CommentReplyService;
import wen.short_video.system.service.VideoCommentService;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/comm")
public class CommentController {

    @Resource
    private VideoCommentService commentService;

    @Resource
    private CommentReplyService replyService;
    /**
     * 返回视频评论
     * @param videoId
     * @param page
     * @return
     */
    @PostMapping("/page/{videoId}")
    public ResponseResult<Page> showComment(@PathVariable long videoId,@RequestBody PageVo page){
        Page<VideoComment> pageinf=new Page<>(page.getPage(), page.getPageSize());
        LambdaQueryWrapper lambdaQueryWrapper=new LambdaQueryWrapper();
//        lambdaQueryWrapper.eq()
        commentService.page(pageinf);
        return new ResponseResult<>(200,"查询成功",pageinf);
    }

    /**
     * 展示回复的评论的评论
     * @param commentId
     * @return
     */
    @PostMapping("/replyShow/{commentId}")
    public ResponseResult replyCommentShow(@PathVariable long commentId){
           List replylist =replyService.show(commentId);



        return new ResponseResult(200,"查询成功");
    }



}
