package com.mbyte.easy.device.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mbyte.easy.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 设备信息表
 * </p>
 *
 * @author 会写代码的怪叔叔
 * @since 2019-07-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_device")
public class Device extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 机器型号
     */
    private String machineType;

    /**
     * 机器品牌
     */
    private String brand;

    /**
     * 序列号
     */
    private String serialNo;

    /**
     * 名称
     */
    private String machineName;

    /**
     * 设备状态（1.正常 2.正在申请 3. 经办人已同意 4.已借出 5.设备损坏）
     */
    private Integer deviceStatus;

    /**
     * 删除状态（1.正常 2. 删除）
     */
    private Integer status;


}
