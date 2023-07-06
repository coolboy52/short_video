package wen.short_video.system.entity;
//菜单

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    // 菜单ID
    private String menuId;
    
    // 菜单名称
    private String menuName;
    
    // 菜单URL
    private String menuUrl;
    
    // 父菜单ID
    private String parentMenuId;
}