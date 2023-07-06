package wen.short_video.system.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
//用户统计表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserStatistic {
    // 主键ID
    private String id;
    
    // 用户ID
    private String userId;
    
    // 视频数量
    private int videoCount;
    
    // 点赞数量
    private int likeCount;
    
    // 关注数量
    private int followingCount;
    
    // 粉丝数量
    private int followerCount;
    
    // 历史记录数量
    private int historyCount;
    
    // 创建时间
    private Date createTime;
}