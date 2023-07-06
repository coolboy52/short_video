package wen.short_video.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
//反馈表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    // 主键ID
    private String id;
    
    // 用户ID
    private String userId;
    
    // 反馈内容
    private String content;
    
    // 创建时间
    private Date createTime;
}