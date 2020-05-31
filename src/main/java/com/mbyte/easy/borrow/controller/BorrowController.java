package com.mbyte.easy.borrow.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mbyte.easy.borrow.entity.Borrow;
import com.mbyte.easy.borrow.service.IBorrowService;
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
@RequestMapping("/borrow/borrow")
public class BorrowController extends BaseController  {

    private String prefix = "borrow/borrow/";

    @Autowired
    private IBorrowService borrowService;

    /**
    * 查询列表
    *
    * @param model
    * @param pageNo
    * @param pageSize
    * @param borrow
    * @return
    */
    @RequestMapping
    public String index(Model model,@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, String createTimeSpace, Borrow borrow) {
        Page<Borrow> page = new Page<Borrow>(pageNo, pageSize);
        QueryWrapper<Borrow> queryWrapper = new QueryWrapper<Borrow>();
        if(!ObjectUtils.isEmpty(borrow.getDeviceId())) {
            queryWrapper = queryWrapper.like("device_id",borrow.getDeviceId());
         }
        if(!ObjectUtils.isEmpty(borrow.getStuId())) {
            queryWrapper = queryWrapper.like("stu_id",borrow.getStuId());
         }
        if(!ObjectUtils.isEmpty(borrow.getRenew())) {
            queryWrapper = queryWrapper.like("renew",borrow.getRenew());
         }
        if(!ObjectUtils.isEmpty(borrow.getOperator())) {
            queryWrapper = queryWrapper.like("operator",borrow.getOperator());
         }
        IPage<Borrow> pageInfo = borrowService.page(page, queryWrapper);
        model.addAttribute("searchInfo", borrow);
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
    * @param borrow
    * @return
    */
    @PostMapping("add")
    @ResponseBody
    public AjaxResult add(Borrow borrow){
        return toAjax(borrowService.save(borrow));
    }
    /**
    * 添加跳转页面
    * @return
    */
    @GetMapping("editBefore/{id}")
    public String editBefore(Model model,@PathVariable("id")Long id){
        model.addAttribute("borrow",borrowService.getById(id));
        return prefix+"edit";
    }
    /**
    * 添加
    * @param borrow
    * @return
    */
    @PostMapping("edit")
    @ResponseBody
    public AjaxResult edit(Borrow borrow){
        return toAjax(borrowService.updateById(borrow));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(borrowService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    @ResponseBody
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(borrowService.removeByIds(ids));
    }

}

