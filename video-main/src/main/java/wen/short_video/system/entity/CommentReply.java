package wen.short_video.system.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentReply {
    private Long id;
    //回复对象名字
    private Integer replyObject;
    //回复者id
    private Long replyId;
    //回复内容
    private String replyContext;
    //回复时间
    private Date replyTime;
    //被回复者id
    private Long beReplyId;
    //回复路径
    private String replyPath;
    //回复类型
    private int replyType;
    //点赞数
    private long likeNumber;
}