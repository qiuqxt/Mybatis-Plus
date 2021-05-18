package com.albert.plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

// ActiveRecord（AR）
// 写一个实体类，继承Model，Model定义了表的CRUD方法。

/**
 * 使用AR，要求实体类需要继承MP中的Model
 * Model中提供了对数据库的CRUD的操作
 */
public class Dept extends Model<Dept> {

    // 指定主键
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String mobile;
    private Integer manager;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getManager() {
        return manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", manager=" + manager +
                '}';
    }
}
