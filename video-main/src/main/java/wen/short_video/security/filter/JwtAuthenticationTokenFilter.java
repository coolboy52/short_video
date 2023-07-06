package wen.short_video.security.filter;


import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import wen.short_video.security.domain.dto.LoginUserDto;
import wen.short_video.security.until.JwtUtil;
import wen.short_video.security.until.RedisCache;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Service
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("token");
        if(!StringUtils.hasText(token)){
            filterChain.doFilter(request,response);
            return;
        }
        String userid;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userid = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }
        String redisKey="token:"+userid;
        LoginUserDto loginUser = redisCache.getCacheObject(redisKey);
        Object o = redisTemplate.opsForValue().get(redisKey);
        if(Objects.isNull(loginUser)){
            throw new RuntimeException("token过时或者失效，登录失败");}
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        filterChain.doFilter(request,response);
    }




}
