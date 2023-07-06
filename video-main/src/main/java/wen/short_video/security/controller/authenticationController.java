package wen.short_video.security.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wen.short_video.security.common.InMemoryUserDetailsManager;
import wen.short_video.security.domain.dto.AuthUserDto;
import wen.short_video.security.domain.dto.LoginUserDto;
import wen.short_video.security.until.JwtUtil;
import wen.short_video.system.common.ResponseResult;
import wen.short_video.system.entity.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RequestMapping("/safe")
@RestController
public class authenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody AuthUserDto authUserDto, HttpServletRequest request){

        //调用方法进行认证，认证成功返回之前自定义的内容UserDetailsServiceImpl
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(authUserDto.getUserName(),authUserDto.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //若为空认证失败
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("账号密码错误，登录失败");
        }
        LoginUserDto principal = (LoginUserDto) authenticate.getPrincipal();
        String userId = principal.getUser().getId().toString();
        String userJwt = JwtUtil.createJWT(userId);
        Map<String,String> jwtMap=new HashMap<>();
        jwtMap.put("token",userJwt);
        redisTemplate.opsForValue().set("token:"+userId,principal);
        return new ResponseResult(200,"登录成功",jwtMap);
    }

    @PostMapping("/logout")
    public ResponseResult logout(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        LoginUserDto principal = (LoginUserDto) authentication.getPrincipal();
        Long userId = principal.getUser().getId();
        redisTemplate.delete("token:"+userId);
        return new ResponseResult(200,"退出成功");
    }

}
