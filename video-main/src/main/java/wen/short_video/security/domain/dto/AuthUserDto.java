package wen.short_video.security.domain.dto;


import lombok.Data;

@Data
public class AuthUserDto {
    //账号名
    private String userName;
    //密码
    private Integer password;
    //验证码
    private Integer code;



}
