package wen.short_video.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * 用户表
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User {
    /** 用户ID */
    @TableId
    private Long id;
    /** 用户名 */
    private String userName;
    /** 头像图片地址 */
    private String avatar;
    /** 性别：0-未知，1-男，2-女 */
    private Integer gender;
    /** 年龄 */
    private Integer age;
    /** 个性签名 */
    private String signature;
    /** 粉丝数 */
    private Integer followerCount;
    /** 关注数 */
    private Integer followingCount;
    /** 创建时间 */
    private Date createTime;
    /** 昵称 */
    private String nickname;
    /** 手机号码 */
    private String phone;
    /** 电子邮箱 */
    private String email;
    /** 密码 */
    private String password;
    /** 账号 */
    private String account;
    /** 状态：0-禁用，1-启用 */
    private Integer status;
    /** 创建者 */
    private Long creator;
    /** 更新者 */
    private Long updater;
    /** 密码修改时间 */
    private Date passwordUpdatedAt;
    /** 更新时间 */
    private Date updatedAt;


}
