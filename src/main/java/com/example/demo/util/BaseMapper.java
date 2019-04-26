package com.example.demo.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author: slicing
 * @Date: 2019/4/26 22:42
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
