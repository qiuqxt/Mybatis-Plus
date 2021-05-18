package com.albert.plus.mapper;

import com.albert.plus.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {
    List<Student> selectByName();
}
