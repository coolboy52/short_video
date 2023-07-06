package wen.short_video.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TFlow {
    /**
     * 流程ID
     */
    private String id;

    /**
     * 流程
     */
    private String flow;

    /**
     * 流程描述
     */
    private String flowDesc;

    /**
     * 流程时序绘制
     */
    private String process;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createUsername;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人
     */
    private String updateUsername;
}