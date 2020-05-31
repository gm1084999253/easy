package com.mbyte.easy.device.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mbyte.easy.device.entity.Device;
import com.mbyte.easy.device.service.IDeviceService;
import com.mbyte.easy.common.controller.BaseController;
import com.mbyte.easy.common.web.AjaxResult;
import com.mbyte.easy.util.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.ObjectUtils;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
* <p>
* 前端控制器
* </p>
* @author 会写代码的怪叔叔
* @since 2019-03-11
*/
@Controller
@RequestMapping("/device/device")
public class DeviceController extends BaseController  {

    private String prefix = "device/device/";

    @Autowired
    private IDeviceService deviceService;

    /**
    * 查询列表
    *
    * @param model
    * @param pageNo
    * @param pageSize
    * @param device
    * @return
    */
    @RequestMapping
    public String index(Model model,@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, Device device) {
        Page<Device> page = new Page<Device>(pageNo, pageSize);
        QueryWrapper<Device> queryWrapper = new QueryWrapper<Device>();
        if(!ObjectUtils.isEmpty(device.getMachineType())) {
            queryWrapper = queryWrapper.like("machine_type",device.getMachineType());
         }
        if(!ObjectUtils.isEmpty(device.getBrand())) {
            queryWrapper = queryWrapper.like("brand",device.getBrand());
         }
        if(!ObjectUtils.isEmpty(device.getSerialNo())) {
            queryWrapper = queryWrapper.like("serial_no",device.getSerialNo());
         }
        if(!ObjectUtils.isEmpty(device.getMachineName())) {
            queryWrapper = queryWrapper.like("machine_name",device.getMachineName());
         }
        if(!ObjectUtils.isEmpty(device.getDeviceStatus())) {
            queryWrapper = queryWrapper.like("device_status",device.getDeviceStatus());
         }
        if(!ObjectUtils.isEmpty(device.getStatus())) {
            queryWrapper = queryWrapper.like("status",device.getStatus());
         }
        IPage<Device> pageInfo = deviceService.page(page, queryWrapper);
        model.addAttribute("searchInfo", device);
        model.addAttribute("pageInfo", new PageInfo(pageInfo));
        return prefix+"list";
    }

    /**
    * 添加跳转页面
    * @return
    */
    @GetMapping("addBefore")
    public String addBefore(){
        return prefix+"add";
    }
    /**
    * 添加
    * @param device
    * @return
    */
    @PostMapping("add")
    @ResponseBody
    public AjaxResult add(Device device){
        return toAjax(deviceService.save(device));
    }
    /**
    * 添加跳转页面
    * @return
    */
    @GetMapping("editBefore/{id}")
    public String editBefore(Model model,@PathVariable("id")Long id){
        model.addAttribute("device",deviceService.getById(id));
        return prefix+"edit";
    }
    /**
    * 添加
    * @param device
    * @return
    */
    @PostMapping("edit")
    @ResponseBody
    public AjaxResult edit(Device device){
        return toAjax(deviceService.updateById(device));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(deviceService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    @ResponseBody
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(deviceService.removeByIds(ids));
    }

}

