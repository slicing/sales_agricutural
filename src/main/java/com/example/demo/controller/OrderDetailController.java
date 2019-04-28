package com.example.demo.controller;

import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.Result;
import com.example.demo.service.OrderDetailService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: slicing
 * @Date: 2019/4/28 11:45
 */
@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/all")
    public Result getAll(int pageNum, int pageSize){
        PageInfo pageInfo = orderDetailService.selectAll(pageNum,pageSize);
        return new Result("success","查询成功",pageInfo);
    }

    @GetMapping("/id")
    public Result getOne(Integer id){
        OrderDetail orderDetail = orderDetailService.getOne(id);
        return new Result("success","查询成功",orderDetail);
    }

    @GetMapping("/orderId")
    public Result getOrderId(int pageNum, int pageSize, int orderId){
        PageInfo pageInfo = orderDetailService.selectByOrderId(pageNum,pageSize,orderId);
        return new Result("success","查询成功",pageInfo);
    }


    @GetMapping("/commodityId")
    public Result getCommodityId(int pageNum, int pageSize, int commodityId){
        PageInfo pageInfo = orderDetailService.selectByCommodityId(pageNum,pageSize,commodityId);
        return new Result("success","查询成功",pageInfo);
    }

    @GetMapping("/commodityName")
    public Result getCommodityName(int pageNum, int pageSize, String commodityName){
        PageInfo pageInfo = orderDetailService.selectCommodityName(pageNum, pageSize, commodityName);
        return new Result("success","查询成功",pageInfo);
    }

    @PostMapping("/insert")
    public Result insert(OrderDetail orderDetail){
        int result = orderDetailService.insert(orderDetail);
        if (result == 0){
            return new Result("success","添加失败");
        }
        return new Result("success","添加成功");
    }

    @PutMapping("/update")
    public Result update(OrderDetail orderDetail){
        int result = orderDetailService.update(orderDetail);
        if (result == 0){
            return new Result("success","修改失败");
        }
        return new Result("success","修改成功");
    }

    @PutMapping("/delete")
    public Result delete(OrderDetail orderDetail){
        int result = orderDetailService.delete(orderDetail);
        if (result == 0){
            return new Result("success","删除失败");
        }
        return new Result("success","删除成功");
    }

}
