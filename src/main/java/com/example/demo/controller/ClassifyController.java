package com.example.demo.controller;

import com.example.demo.entity.Classify;
import com.example.demo.entity.Result;
import com.example.demo.service.ClassifyService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: slicing
 * @Date: 2019/4/27 19:30
 */
@RestController
@RequestMapping("/classify")
public class ClassifyController {
    @Autowired
    private ClassifyService classifyService;

    @GetMapping("/All")
    public Result getAll(int pageNum, int pageSize){
        PageInfo pageInfo = classifyService.selectAll(pageNum,pageSize);
        return new Result("success","查询成功", pageInfo);
    }

    @GetMapping("/AllList")
    public Result selectAll(){
        List<Classify> classifies = classifyService.getAll();
        return new Result("success","查询成功", classifies);
    }

    @GetMapping("/Name")
    public Result getName(String name){
        Classify classify = classifyService.selectByName(name);
        return new Result("success","查询成功", classify);
    }

    @GetMapping("/Id")
    public Result getOne(Integer id){
        Classify classify = classifyService.getOne(id);
        return new Result("success","查询成功", classify);
    }

    @PostMapping("/insert")
    public Result insert(Classify classify){
        int result = classifyService.insert(classify);
        if (result == 0){
            return new Result("error", "增加失败");
        }
        return new Result("success", "增加成功");
    }

    @PutMapping("/update")
    public Result update(Classify classify){
        int result  = classifyService.update(classify);
        if (result == 0){
            return new Result("error", "更新失败");
        }
        return new Result("success", "更新成功");
    }


    @PutMapping("/delete")
    public Result delete(Classify classify){
        int result = classifyService.delete(classify);
        if (result == 0){
            return new Result("error", "删除失败");
        }
        return new Result("success", "删除成功");
    }

}
