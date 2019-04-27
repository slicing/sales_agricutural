package com.example.demo.service.impl;

import com.example.demo.entity.Classify;
import com.example.demo.mapper.ClassifyMapper;
import com.example.demo.service.ClassifyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: slicing
 * @Date: 2019/4/27 9:54
 */
@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    private ClassifyMapper classifyMapper;
    @Override
    public PageInfo selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Classify> classifyList = classifyMapper.selectAll();
        PageInfo pageInfo = new PageInfo(classifyList);
        return pageInfo;
    }

    @Override
    public List<Classify> getAll() {
        return classifyMapper.selectAll();
    }

    @Override
    public Classify getOne(Integer id) {
        return classifyMapper.selectByPrimaryKey(id);
    }

    @Override
    public Classify selectByName(String name) {
        return classifyMapper.selectByName(name);
    }

    @Override
    public int insert(Classify classify) {
        return classifyMapper.insert(classify);
    }

    @Override
    public int update(Classify classify) {
        return classifyMapper.updateByPrimaryKeySelective(classify);
    }

    @Override
    public int delete(Classify classify) {
        return classifyMapper.delete(classify);
    }
}
