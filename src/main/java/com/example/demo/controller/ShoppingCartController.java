package com.example.demo.controller;

import com.example.demo.entity.Commodity;
import com.example.demo.entity.Result;
import com.example.demo.entity.ShoppingCart;
import com.example.demo.service.CommodityService;
import com.example.demo.service.ShoppingCartService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: slicing
 * @Date: 2019/4/27 19:50
 */
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private CommodityService commodityService;

    @GetMapping("/All")
    public Result getAll(int pageNum, int pageSize){
        PageInfo pageInfo = shoppingCartService.selectAll(pageNum,pageSize);
        return new Result("success","查询成功", pageInfo);
    }

    @GetMapping("/UserId")
    public Result getUserId(int pageNum, int pageSize, int userId){
        PageInfo pageInfo = shoppingCartService.selectByUserId(pageNum,pageSize,userId);
        return new Result("success","查询成功", pageInfo);
    }

    @GetMapping("/Id")
    public Result getOne(Integer id){
        ShoppingCart shoppingCart = shoppingCartService.getOne(id);
        return new Result("success","查询成功",shoppingCart);
    }

    @GetMapping("/CommodityId")
    public Result getCommodityId(int pageNum, int pageSize, int commodityId){
        PageInfo pageInfo = shoppingCartService.selectByCommodityId(pageNum,pageSize,commodityId);
        return new Result("success","查询成功", pageInfo);
    }

    @PostMapping("/insert")
    public Result insert(ShoppingCart shoppingCart){
        int result = shoppingCartService.insert(shoppingCart);
        if (result == 0){
            return new Result("error", "增加失败");
        }
        return new Result("success", "增加成功");
    }

    @PutMapping("/update")
    public Result update(ShoppingCart shoppingCart){
        int result  = shoppingCartService.update(shoppingCart);
        if (result == 0){
            return new Result("error", "更新失败");
        }
        return new Result("success", "更新成功");
    }

    @PutMapping("/Settlement")
    public Result updateByOrder(Integer id,int num){
        Commodity commodity = commodityService.getOne(id);
        if(commodity.getNumber() > num ){
            commodity.setNumber(commodity.getNumber() - num);
            commodityService.update(commodity);
        }


    }


    @PutMapping("/delete")
    public Result delete(ShoppingCart shoppingCart){
        int result = shoppingCartService.delete(shoppingCart);
        if (result == 0){
            return new Result("error", "删除失败");
        }
        return new Result("success", "删除成功");
    }
}
