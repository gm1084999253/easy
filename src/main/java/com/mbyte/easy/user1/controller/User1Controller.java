package com.mbyte.easy.user1.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mbyte.easy.user1.entity.User1;
import com.mbyte.easy.user1.service.IUser1Service;
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
@RequestMapping("/user1/user1")
public class User1Controller extends BaseController  {

    private String prefix = "user1/user1/";

    @Autowired
    private IUser1Service user1Service;

    /**
    * 查询列表
    *
    * @param model
    * @param pageNo
    * @param pageSize
    * @param user1
    * @return
    */
    @RequestMapping
    public String index(Model model,@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, String lastTimeSpace, String createTimeSpace, User1 user1) {
        Page<User1> page = new Page<User1>(pageNo, pageSize);
        QueryWrapper<User1> queryWrapper = new QueryWrapper<User1>();
        if(!ObjectUtils.isEmpty(user1.getUsername())) {
            queryWrapper = queryWrapper.like("username",user1.getUsername());
         }
        if(!ObjectUtils.isEmpty(user1.getEmail())) {
            queryWrapper = queryWrapper.like("email",user1.getEmail());
         }
        if(!ObjectUtils.isEmpty(user1.getPassword())) {
            queryWrapper = queryWrapper.like("password",user1.getPassword());
         }
        if(!ObjectUtils.isEmpty(user1.getState())) {
            queryWrapper = queryWrapper.like("state",user1.getState());
         }
        if(!ObjectUtils.isEmpty(user1.getCode())) {
            queryWrapper = queryWrapper.like("code",user1.getCode());
         }
        if(!ObjectUtils.isEmpty(user1.getStudentId())) {
            queryWrapper = queryWrapper.like("studentId",user1.getStudentId());
         }
        if(!ObjectUtils.isEmpty(user1.getSchool())) {
            queryWrapper = queryWrapper.like("school",user1.getSchool());
         }
        if(!ObjectUtils.isEmpty(user1.getSchoolId())) {
            queryWrapper = queryWrapper.like("schoolId",user1.getSchoolId());
         }
        if(!ObjectUtils.isEmpty(user1.getStudentImg())) {
            queryWrapper = queryWrapper.like("studentImg",user1.getStudentImg());
         }
        if(!ObjectUtils.isEmpty(user1.getLastTime())) {
            queryWrapper = queryWrapper.like("lastTime",user1.getLastTime());
         }
        IPage<User1> pageInfo = user1Service.page(page, queryWrapper);
        model.addAttribute("lastTimeSpace", lastTimeSpace);
        model.addAttribute("searchInfo", user1);
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
    * @param user1
    * @return
    */
    @PostMapping("add")
    @ResponseBody
    public AjaxResult add(User1 user1){
        return toAjax(user1Service.save(user1));
    }
    /**
    * 添加跳转页面
    * @return
    */
    @GetMapping("editBefore/{id}")
    public String editBefore(Model model,@PathVariable("id")Long id){
        model.addAttribute("user1",user1Service.getById(id));
        return prefix+"edit";
    }
    /**
    * 添加
    * @param user1
    * @return
    */
    @PostMapping("edit")
    @ResponseBody
    public AjaxResult edit(User1 user1){
        return toAjax(user1Service.updateById(user1));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(user1Service.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    @ResponseBody
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(user1Service.removeByIds(ids));
    }

}

