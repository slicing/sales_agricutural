package com.example.demo.service;

import com.example.demo.entity.Classify;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: slicing
 * @Date: 2019/4/27 9:47
 */
public interface ClassifyService {
    PageInfo selectAll(int pageNum, int pageSize);

    List<Classify> getAll();

    Classify getOne(Integer id);

    Classify selectByName(String name);

    int insert(Classify classify);

    int update(Classify classify);

    int delete(Classify classify);

}
