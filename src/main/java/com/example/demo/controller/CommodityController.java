package com.example.demo.controller;

import com.example.demo.entity.Commodity;
import com.example.demo.entity.Result;
import com.example.demo.service.CommodityService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: slicing
 * @Date: 2019/4/27 19:38
 */
@RestController
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @GetMapping("/All")
    public Result getAll(int pageNum, int pageSize){
        PageInfo pageInfo = commodityService.selectAll(pageNum,pageSize);
        return new Result("success","查询成功", pageInfo);
    }

    @GetMapping("/Id")
    public Result getOne(Integer id){
        Commodity commodity = commodityService.getOne(id);
        return new Result("success","查询成功", commodity);
    }

    @GetMapping("/Name")
    public Result getName(int pageNum, int pageSize, String name){
        PageInfo pageInfo = commodityService.selectByName(pageNum,pageSize,name);
        return new Result("success","查询成功", pageInfo);
    }

    @GetMapping("/ClassifyId")
    public Result getClassifyId(int pageNum, int pageSize, int classifyId){
        PageInfo pageInfo = commodityService.selectClassifyId(pageNum,pageSize,classifyId);
        return new Result("success","查询成功", pageInfo);
    }

    @GetMapping("/state")
    public Result getState(int pageNum, int pageSize, boolean state){
        PageInfo pageInfo = commodityService.selectByState(pageNum,pageSize,state);
        return new Result("success","查询成功", pageInfo);
    }

    @GetMapping("/Num")
    public Result getNum(int pageNum, int pageSize, int num){
        PageInfo pageInfo = commodityService.selectByNum(pageNum,pageSize,num);
        return new Result("success","查询成功", pageInfo);
    }

    @PostMapping("/insert")
    public Result insert(Commodity commodity){
        int result = commodityService.insert(commodity);
        if (result == 0){
            return new Result("error", "增加失败");
        }
        return new Result("success", "增加成功");
    }

    @PutMapping("/update")
    public Result update(Commodity commodity){
        int result  = commodityService.update(commodity);
        if (result == 0){
            return new Result("error", "更新失败");
        }
        return new Result("success", "更新成功");
    }


    @PutMapping("/delete")
    public Result delete(Commodity commodity){
        int result = commodityService.delete(commodity);
        if (result == 0){
            return new Result("error", "删除失败");
        }
        return new Result("success", "删除成功");
    }

}
