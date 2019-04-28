package com.example.demo.controller;

import com.example.demo.entity.OrderMaster;
import com.example.demo.entity.Result;
import com.example.demo.service.OrderMasterService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author: ningyq
 * @Date: 2019/4/28 11:53
 */
@RestController
@RequestMapping("/orderMaster")
public class OrderMasterController {
    @Autowired
    OrderMasterService orderMasterService;

    /**
     * 查询全部订单
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/all")
    public Result getAll(int pageNum, int pageSize){
        PageInfo pageInfo = orderMasterService.selectAll(pageNum,pageSize);
        return new Result("success","查询成功", pageInfo);
    }

    /**
     * 根据编号查询
     * @param id
     * @return
     */
    @GetMapping("/id")
    public Result getById(Integer id) {
        OrderMaster orderMaster = orderMasterService.getOne(id);
        return new Result("success", "查询成功", orderMaster);
    }

    /**
     * 根据用户编号查询
     * @param pageNum
     * @param pageSize
     * @param id
     * @return
     */
    @GetMapping("/userId")
    public Result getByUserId(int pageNum, int pageSize, Integer id) {
        PageInfo pageInfo = orderMasterService.selectByUserId(pageNum, pageSize, id);
        return new Result("success", "查询成功", pageInfo);
    }

    /**
     * 根据订单状态查询
     * @param pageNum
     * @param pageSize
     * @param state
     * @return
     */
    @GetMapping("/orderState")
    public Result getByOrderState(int pageNum, int pageSize, Integer state) {
        PageInfo pageInfo = orderMasterService.selectByOrderState(pageNum, pageSize, state);
        return new Result("success", "查询成功", pageInfo);
    }

    /**
     * 根据支付状态查询
     * @param pageNum
     * @param pageSize
     * @param state
     * @return
     */
    @GetMapping("/payState")
    public Result getByPayStatus(int pageNum, int pageSize, boolean state) {
        PageInfo pageInfo = orderMasterService.selectByPayState(pageNum, pageSize, state);
        return new Result("success", "查询成功", pageInfo);
    }

    /**
     * 根据订单创建时间查询
     * @param pageNum
     * @param pageSize
     * @param date
     * @return
     */
    @GetMapping("/createTime")
    public Result getByCreateTime(int pageNum, int pageSize, Date date) {
        PageInfo pageInfo = orderMasterService.selectByCreateTime(pageNum, pageSize, date);
        return new Result("success", "查询成功", pageInfo);
    }

    /**
     * 创建订单
     * @param orderMaster
     * @return
     */
    @PostMapping("/insert")
    public Result insert(OrderMaster orderMaster){
        int result = orderMasterService.insert(orderMaster);
        if (result == 0){
            return new Result("error", "增加失败");
        }
        return new Result("success", "增加成功");
    }

    /**
     * 更新支付状态
     * @param id
     * @return
     */
    @PutMapping("/updatePayState")
    public Result updatePayState(int id){
        OrderMaster orderMaster = orderMasterService.getOne(id);
        if (orderMaster.getPayState()){
            orderMaster.setPayState(false);
        }
        else
            orderMaster.setPayState(true);
        int result = orderMasterService.update(orderMaster);
        if (result == 0){
            return new Result("error", "更新失败");
        }
        return new Result("success", "更新成功");
    }

    /**
     * 删除订单
     * @param orderMaster
     * @return
     */
    @PutMapping("/delete")
    public Result delete(OrderMaster orderMaster){
        int result = orderMasterService.delete(orderMaster);
        if (result == 0){
            return new Result("error", "删除失败");
        }
        return new Result("success", "删除成功");
    }
}
