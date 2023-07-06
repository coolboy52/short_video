package wen.short_video.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;
/**
 * 视频表
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
//@Alias("Video")
public class Video {
    // 视频ID
    private String id;

    // 用户ID
    private String userId;

    // 视频名称
    private String videoName;

    // 视频描述
    private String videoDesc;

    // 视频URL
    private String videoUrl;

    // 封面URL
    private String coverUrl;

    // 点赞数
    private String likeCount;

    // 评论数
    private String commentCount;

    // 播放数
    private String playCount;

    // 创建时间
    private Date createTime;

    //视频收藏数
    private String videoCollect;
    //视频转发数
    private String videoTranspond;

    // 省略了getter和setter方法


    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", videoName='" + videoName + '\'' +
                ", videoDesc='" + videoDesc + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", likeCount='" + likeCount + '\'' +
                ", commentCount='" + commentCount + '\'' +
                ", playCount='" + playCount + '\'' +
                ", createTime=" + createTime +
                ", videoCollect='" + videoCollect + '\'' +
                ", videoTranspond='" + videoTranspond + '\'' +
                '}';
    }
}
