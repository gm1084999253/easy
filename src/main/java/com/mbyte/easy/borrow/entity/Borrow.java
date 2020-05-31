package com.mbyte.easy.borrow.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mbyte.easy.common.entity.BaseEntity;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 历史借阅记录表
 * </p>
 *
 * @author 会写代码的怪叔叔
 * @since 2019-07-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("device_borrow")
public class Borrow extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 设备id
     */
    private Long deviceId;

    /**
     * 学生id
     */
    private Long stuId;

    /**
     * createTime
     */
    private LocalDateTime createTime;

    /**
     * updateTime
     */
    private LocalDateTime updateTime;

    /**
     * 续借次数
     */
    private Integer renew;

    /**
     * 经办人
     */
    private String operator;


}
