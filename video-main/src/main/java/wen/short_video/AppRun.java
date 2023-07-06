package wen.short_video;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("wen/short_video/system/mapper")
@SpringBootApplication
public class AppRun {

    public static void main(String[] args) {
        SpringApplication.run(AppRun.class,args);
    }
}
