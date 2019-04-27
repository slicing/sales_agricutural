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

    /**
     * 显示所有商品
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/All")
    public Result getAll(int pageNum, int pageSize){
        PageInfo pageInfo = commodityService.selectAll(pageNum,pageSize);
        return new Result("success","查询成功", pageInfo);
    }

    /**
     * 根据编号查询商品信息
     * @param id
     * @return
     */
    @GetMapping("/Id")
    public Result getOne(Integer id){
        Commodity commodity = commodityService.getOne(id);
        return new Result("success","查询成功", commodity);
    }

    /**
     * 根据商品名称查询商品信息
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/Name")
    public Result getName(int pageNum, int pageSize, String name){
        PageInfo pageInfo = commodityService.selectByName(pageNum,pageSize,name);
        return new Result("success","查询成功", pageInfo);
    }

    /**
     * 根据分类查询商品信息
     * @param pageNum
     * @param pageSize
     * @param classifyId
     * @return
     */
    @GetMapping("/ClassifyId")
    public Result getClassifyId(int pageNum, int pageSize, int classifyId){
        PageInfo pageInfo = commodityService.selectClassifyId(pageNum,pageSize,classifyId);
        return new Result("success","查询成功", pageInfo);
    }

    /**
     * 根据商品状态查询商品信息
     * @param pageNum
     * @param pageSize
     * @param state
     * @return
     */
    @GetMapping("/state")
    public Result getState(int pageNum, int pageSize, boolean state){
        PageInfo pageInfo = commodityService.selectByState(pageNum,pageSize,state);
        return new Result("success","查询成功", pageInfo);
    }


    /**
     * 根据商品数量查询商品信息
     * @param pageNum
     * @param pageSize
     * @param num
     * @return
     */
    @GetMapping("/Num")
    public Result getNum(int pageNum, int pageSize, int num){
        PageInfo pageInfo = commodityService.selectByNum(pageNum,pageSize,num);
        return new Result("success","查询成功", pageInfo);
    }

    /**
     * 增加商品
     * @param commodity
     * @return
     */
    @PostMapping("/insert")
    public Result insert(Commodity commodity){
        int result = commodityService.insert(commodity);
        if (result == 0){
            return new Result("error", "增加失败");
        }
        return new Result("success", "增加成功");
    }

    /**
     * 商品上架/下架
     * @param id
     * @return
     */
    @PutMapping("/updateState")
    public Result updateState(int id){
        Commodity commodity = commodityService.getOne(id);
        if (commodity.getState()){
            commodity.setState(false);
        }
        else
            commodity.setState(true);
        int result = commodityService.update(commodity);
        if (result == 0){
            return new Result("error", "更新失败");
        }
        return new Result("success", "更新成功");
    }
    /**
     * 更新商品信息
     * @param commodity
     * @return
     */
    @PutMapping("/update")
    public Result update(Commodity commodity){
        int result  = commodityService.update(commodity);
        if (result == 0){
            return new Result("error", "更新失败");
        }
        return new Result("success", "更新成功");
    }


    /**
     * 删除商品
     * @param commodity
     * @return
     */
    @PutMapping("/delete")
    public Result delete(Commodity commodity){
        int result = commodityService.delete(commodity);
        if (result == 0){
            return new Result("error", "删除失败");
        }
        return new Result("success", "删除成功");
    }

}
