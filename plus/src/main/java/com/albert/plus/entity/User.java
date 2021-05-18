package com.albert.plus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

// 定义实体类，默认的表名和实体类同名；如果不一致，在实体类定义上面使用如下注解
// @TableName(value = "数据库表名")
@TableName(value = "User")
public class User {

    /**
     *     指定主键的方式
     *     value：主键字段的名称，如果是id，可以不用写
     *     type：指定主键的类型，主键的值如何生成，IdType.AUTO 表示自动增长
     *
     *     IdType的枚举类型：
     *              AUTO(0)         //自动增长
     *              NONE(1)         //没有主键
     *              INPUT(2)        //手工输入
     *              ID_WORKER(3)    //实体类用Long id，表的列用bigint，int类型大小不够
     *              UUID(4)         //实体类使用String id，表的列使用 varchar 50
     *              ID_WORKER_STR(5)//实体类使用String id，表的列使用 varchar 50
     *
     */
    @TableId(
            value = "id",
            type = IdType.AUTO
    )
    private Integer id;

    // 指定列名，当属性和表中字段的名称不一致时
    // 注解value是字段名称
    @TableField(value = "name")
    private String name;
    private String email;
    private Integer age;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
