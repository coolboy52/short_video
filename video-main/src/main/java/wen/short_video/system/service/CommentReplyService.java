package wen.short_video.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import wen.short_video.system.entity.CommentReply;

import java.util.List;

public interface CommentReplyService extends IService<CommentReply> {
    List show(long commentId);
}
