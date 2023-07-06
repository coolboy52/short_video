package wen.short_video.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TFlowProcessRelation {
    /**
     * 流程与工序关系ID
     */
    private String id;

    /**
     * 流程ID
     */
    private String flowId;

    /**
     * 流程代码
     */
    private String flow;

    /**
     * 前道工序
     */
    private String perProcess;

    /**
     * 前道工序ID
     */
    private String perProcessId;

    /**
     * 当前工序
     */
    private String Process;

    /**
     * 当前工序ID
     */
    private String ProcessId;

    /**
     * 下道工序
     */
    private String nextProcess;

    /**
     * 下道工序ID
     */
    private String nextProcessId;

    /**
     * 排序
     */
    private String sortNum;

    /**
     * 工序类型 (首道工序firstOper;最后一道工序lastOper)
     */
    private String operType;
}