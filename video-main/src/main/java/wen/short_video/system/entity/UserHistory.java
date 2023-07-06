package wen.short_video.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
//用户历史
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserHistory {
    // 主键ID
    private String id;
    
    // 用户ID
    private String userId;
    
    // 视频ID
    private String videoId;
    
    // 创建时间
    private Date createTime;
}