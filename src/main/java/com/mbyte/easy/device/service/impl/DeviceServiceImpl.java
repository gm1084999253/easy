package com.mbyte.easy.device.service.impl;

import com.mbyte.easy.device.entity.Device;
import com.mbyte.easy.device.mapper.DeviceMapper;
import com.mbyte.easy.device.service.IDeviceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 设备信息表 服务实现类
 * </p>
 *
 * @author 会写代码的怪叔叔
 * @since 2019-07-31
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements IDeviceService {

}
