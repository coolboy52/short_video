package wen.short_video.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoReport {
    // 报告ID
    private int id;
    // 用户ID
    private int userId;
    // 视频ID
    private int videoId;
    // 举报类型
    private String type;
    // 举报时间
    private Date reportTime;
}