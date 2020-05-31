package com.mbyte.easy.apply.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mbyte.easy.common.entity.BaseEntity;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 设备申请记录表
 * </p>
 *
 * @author 会写代码的怪叔叔
 * @since 2019-08-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("device_apply")
public class Apply extends BaseEntity {

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
     * 续借次数
     */
    private Integer renew;

    /**
     * 经办人
     */
    private String operator;

    /**
     * 1.正在申请 2.经办人同意 3.经办人拒绝 4.老师同意 5.老师拒绝
     */
    private Integer status;

    /**
     * 申请时间
     */
    private LocalDateTime applyTime;

    /**
     * 归还时间
     */
    private LocalDateTime backTime;

    /**
     * createTime
     */
    private LocalDateTime createTime;

    /**
     * updateTime
     */
    private LocalDateTime updateTime;


}
