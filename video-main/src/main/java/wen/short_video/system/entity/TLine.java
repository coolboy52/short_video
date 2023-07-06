package wen.short_video.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TLine {
    private String id;
    private String line;
    private String lineDesc;
    private String lineFlow;
    private String status;
    private String orderCount;
}