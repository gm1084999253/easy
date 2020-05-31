package com.mbyte.easy.class_type.entity;

import com.mbyte.easy.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 会写代码的怪叔叔
 * @since 2019-08-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ClassType extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 年级
     */
    private String grade;

    /**
     * 课程类型
     */
    private String type;

    private String webAddress;


}
