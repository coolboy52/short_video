package wen.short_video.system.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
评论表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoComment {

    //表id
    private String id;

    //评论用户的id
    private String userId;
    //视频的id
    private String videoId;
    //评论内容
    private String content;
    //创建时间
    private String createTime;
    //点赞数
    private long likeNumber;

}
