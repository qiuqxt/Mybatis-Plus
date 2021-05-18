package com.albert.plus.mapper;

import com.albert.plus.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/*
    不使用mapper，也需要定义这个接口，MP通过mapper获取到这个表的结构；
    不定义时，MP报错无法获取到表的结构信息
 */

public interface DeptMapper extends BaseMapper<Dept> {
}
