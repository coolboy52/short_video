package wen.short_video.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//点赞表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeLog {
    // ID
    private String id;
    // 点赞用户ID
    private String userId;
    // 被点赞视频ID
    private String videoId;
    // 创建时间
    private Date createTime;
}