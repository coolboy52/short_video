package wen.short_video.system.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVo {
    //第几页
    private int page;
    //每页的数量
    private int pageSize;

}
