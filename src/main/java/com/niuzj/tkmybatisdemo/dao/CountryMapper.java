package com.niuzj.tkmybatisdemo.dao;


import com.niuzj.tkmybatisdemo.model.Country;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CountryMapper extends Mapper<Country> {

    /**
     * 当方法和Mapper接口的完全相同时,最终会使用自定义的方法
     */
    List<Country> selectAll();
}
