package com.example.demo.service.impl;

import com.example.demo.entity.Commodity;
import com.example.demo.mapper.CommodityMapper;
import com.example.demo.service.CommodityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author: slicing
 * @Date: 2019/4/27 13:49
 */
@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityMapper commodityMapper;
    @Override
    public PageInfo selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Commodity> commodities = commodityMapper.selectAll();
        PageInfo pageInfo = new PageInfo(commodities);
        return pageInfo;
    }

    @Override
    public Commodity getOne(Integer id) {
        return commodityMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo selectByName(int pageNum, int pageSize, String name) {
        PageHelper.startPage(pageNum,pageSize);
        List<Commodity> commodities = commodityMapper.selectByName(name);
        PageInfo pageInfo = new PageInfo(commodities);
        return pageInfo;
    }

    @Override
    public PageInfo selectClassifyId(int pageNum, int pageSize, Integer classifyId) {
        PageHelper.startPage(pageNum,pageSize);
        List<Commodity> commodities = commodityMapper.selectByClassifyId(classifyId);
        PageInfo pageInfo = new PageInfo(commodities);
        return pageInfo;
    }

    @Override
    public PageInfo selectByState(int pageNum, int pageSize, boolean state) {
        PageHelper.startPage(pageNum,pageSize);
        List<Commodity> commodities = commodityMapper.selectByState(state);
        PageInfo pageInfo = new PageInfo(commodities);
        return pageInfo;
    }

    @Override
    public PageInfo selectByNum(int pageNum, int pageSize, int num) {
        PageHelper.startPage(pageNum,pageSize);
        List<Commodity> commodities = commodityMapper.selectByNum(num);
        PageInfo pageInfo = new PageInfo(commodities);
        return pageInfo;
    }

    @Override
    public int insert(Commodity commodity) {
        return commodityMapper.insert(commodity);
    }

    @Override
    @Transactional
    public int update(Commodity commodity) {
        return commodityMapper.updateByPrimaryKeySelective(commodity);
    }

    @Override
    public int delete(Commodity commodity) {
        return commodityMapper.deleteByPrimaryKey(commodity);
    }
}
