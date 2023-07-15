package wen.short_video.system.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wen.short_video.system.entity.CommentReply;
import wen.short_video.system.mapper.CommentReplyMapper;
import wen.short_video.system.service.CommentReplyService;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Service
public class CommentReplyServiceImpl extends ServiceImpl<CommentReplyMapper, CommentReply> implements CommentReplyService {

    @Autowired
    private CommentReplyMapper replyMapper;

    Queue<CommentReply> replyQueue=new ArrayDeque<>();

    //用于存放回复的数据
    List<CommentReply> replyList=new ArrayList<>();

    /**
     * 查询评论的回复
     * @param commentId
     * @return
     */
    @Override
    public List show(long commentId) {
        LambdaQueryWrapper<CommentReply> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(CommentReply::getBeReplyId,commentId);
        queryWrapper.orderByAsc(CommentReply::getLikeNumber);
        CommentReply commentReply = replyMapper.selectOne(queryWrapper);
//        List<CommentReply> replyList=new ArrayList<>();
        replyList.add(commentReply);


        return null;
    }



}
