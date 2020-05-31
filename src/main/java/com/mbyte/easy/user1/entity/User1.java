package com.mbyte.easy.user1.entity;

import com.mbyte.easy.common.entity.BaseEntity;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 会写代码的怪叔叔
 * @since 2019-07-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class User1 extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户激活状态：0表示未激活，1表示激活
     */
    private Integer state;

    /**
     * 激活码
     */
    private String code;

    /**
     * 学号
     */
    @TableField("studentId")
    private Integer studentId;

    /**
     * 学校
     */
    private String school;

    /**
     * 学校id
     */
    @TableField("schoolId")
    private Integer schoolId;

    /**
     * 头像
     */
    @TableField("studentImg")
    private String studentImg;

    /**
     * 最后登录时间
     */
    @TableField("lastTime")
    private LocalDateTime lastTime;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;


}
