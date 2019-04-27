package com.example.demo.service;

import com.example.demo.entity.Commodity;
import com.github.pagehelper.PageInfo;

/**
 * @Author: slicing
 * @Date: 2019/4/27 13:34
 */
public interface CommodityService {

    PageInfo selectAll(int pageNum, int pageSize);

    Commodity getOne(Integer id);

    PageInfo selectByName(int pageNum, int pageSize, String name);

    PageInfo selectClassifyId(int pageNum, int pageSize, Integer classifyId);

    PageInfo selectByState(int pageNum,int pageSize, boolean state);

    PageInfo selectByNum(int pageNum, int pageSize, int num);

    int insert(Commodity commodity);

    int update(Commodity commodity);

    int delete(Commodity commodity);




}
