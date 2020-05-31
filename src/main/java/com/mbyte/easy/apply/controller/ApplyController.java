package com.mbyte.easy.apply.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mbyte.easy.apply.entity.Apply;
import com.mbyte.easy.apply.service.IApplyService;
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
@RequestMapping("/apply/apply")
public class ApplyController extends BaseController  {

    private String prefix = "apply/apply/";

    @Autowired
    private IApplyService applyService;

    /**
    * 查询列表
    *
    * @param model
    * @param pageNo
    * @param pageSize
    * @param apply
    * @return
    */
    @RequestMapping
    public String index(Model model,@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, String applyTimeSpace, String backTimeSpace, String createTimeSpace, String updateTimeSpace, Apply apply) {
        Page<Apply> page = new Page<Apply>(pageNo, pageSize);
        QueryWrapper<Apply> queryWrapper = new QueryWrapper<Apply>();
        if(!ObjectUtils.isEmpty(apply.getDeviceId())) {
            queryWrapper = queryWrapper.like("device_id",apply.getDeviceId());
         }
        if(!ObjectUtils.isEmpty(apply.getStuId())) {
            queryWrapper = queryWrapper.like("stu_id",apply.getStuId());
         }
        if(!ObjectUtils.isEmpty(apply.getRenew())) {
            queryWrapper = queryWrapper.like("renew",apply.getRenew());
         }
        if(!ObjectUtils.isEmpty(apply.getOperator())) {
            queryWrapper = queryWrapper.like("operator",apply.getOperator());
         }
        if(!ObjectUtils.isEmpty(apply.getStatus())) {
            queryWrapper = queryWrapper.like("status",apply.getStatus());
         }
        if(!ObjectUtils.isEmpty(apply.getApplyTime())) {
            queryWrapper = queryWrapper.like("apply_time",apply.getApplyTime());
         }
        if(!ObjectUtils.isEmpty(apply.getBackTime())) {
            queryWrapper = queryWrapper.like("back_time",apply.getBackTime());
         }
        IPage<Apply> pageInfo = applyService.page(page, queryWrapper);
        model.addAttribute("applyTimeSpace", applyTimeSpace);
        model.addAttribute("backTimeSpace", backTimeSpace);
        model.addAttribute("searchInfo", apply);
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
    * @param apply
    * @return
    */
    @PostMapping("add")
    @ResponseBody
    public AjaxResult add(Apply apply){
        return toAjax(applyService.save(apply));
    }
    /**
    * 添加跳转页面
    * @return
    */
    @GetMapping("editBefore/{id}")
    public String editBefore(Model model,@PathVariable("id")Long id){
        model.addAttribute("apply",applyService.getById(id));
        return prefix+"edit";
    }
    /**
    * 添加
    * @param apply
    * @return
    */
    @PostMapping("edit")
    @ResponseBody
    public AjaxResult edit(Apply apply){
        return toAjax(applyService.updateById(apply));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(applyService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    @ResponseBody
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(applyService.removeByIds(ids));
    }

}

