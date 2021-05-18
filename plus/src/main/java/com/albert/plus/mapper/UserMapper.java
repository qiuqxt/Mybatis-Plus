package com.albert.plus.mapper;

import com.albert.plus.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 自定义mapper，就是Dao接口
 * 1.要实现BaseMapper
 * 2.指定实体类
 *
 * BaseMapper是MP框架中的对象，定义17个操作方法（CRUD）
 */

public interface UserMapper extends BaseMapper<User> {
}
