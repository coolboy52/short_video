package wen.short_video.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
//关注映射
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFollow {
    // 主键ID
    private String id;
    
    // 关注者ID
    private String followerId;
    
    // 被关注者ID
    private String followingId;
    
    // 创建时间
    private Date createTime;
}