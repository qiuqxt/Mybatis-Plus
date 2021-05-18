package com.albert.plus;

import com.albert.plus.entity.User;
import com.albert.plus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("all")
@SpringBootTest
class PlusApplicationTests {

    // 使用自动注入，注入Mapper对象
    @Autowired
    private UserMapper userDao;

    // 定义测试方法
    // 测试添加操作，insert
    @Test
    public void testUserInsert(){
        // 创建User对象
        User user = new User();
        user.setName("zhangsan2");
        user.setEmail("zhangsan2@qq.com");
        user.setAge(20);

        // 调用UserMapper的方法，即父接口BaseMapper中提供的方法
        int row = userDao.insert(user);
        System.out.println("insert的结果："+row);
    }

    @Test
    public void testInsertGetId(){
        // 创建User对象
        User user = new User();
        user.setName("zhaoliu");
        user.setEmail("zhaoliu@qq.com");
        user.setAge(20);

        int row = userDao.insert(user);
        System.out.println("insert的结果："+row);

        // 获取主键id，刚添加数据库中的数据的id
        Integer id = user.getId();
        System.out.println("主键id："+id);
    }


    // update
    /**
     * 更新 update
     */
    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(1);
        user.setName("zhangsan");
        user.setEmail("zhangsan@qq.com");
        user.setAge(25);

        // 执行更新，根据主键值更新
        /*
            update 表名 set name=?, email=?, age=?, where id=?
            更新了所有非null的属性值，条件where id = 主键值
         */

        int i = userDao.updateById(user);
        System.out.println("更新记录数："+i);
    }

    /**
     * 控制更新的属性
     */
    @Test
    public void testUpdateUser2(){
        User user = new User();
        user.setId(3);
        user.setName("wangwu");
        //user.setAge(20);

        int rows = userDao.updateById(user);
        System.out.println("更新的记录数："+rows);
    }


    // delete
    /**
     * 删除 delete
     * 按主键删除
     */
    @Test
    public void testDeleteUser(){

        User user = new User();
        user.setId(4);

        int rows = userDao.deleteById(user.getId());
        System.out.println("删除的记录数："+rows);
    }

    /**
     * 根据map删除
     * 删除条件封装在map中，key是列名，value是值，多个key之间and连接
     */
    @Test
    public void testDeleteUserByMap(){
        Map<String, Object> param = new HashMap<>();
        param.put("age",20);
        param.put("name","zhangsan2");

        int rows = userDao.deleteByMap(param);
        System.out.println("删除的记录数："+rows);
    }

    /**
     * 批量删除 BatchIds
     * 注：list集合的创建可以使用lambda表达式，也可以使用add。
     * 把要删除的id放入到idList，传给deleteBatchIds。批量删除使用 in（...）
     */
    @Test
    public void testDeleteBatch(){
        List<Integer> idList = Stream.of(8,9).collect(Collectors.toList());
        idList.add(10);

        int rows = userDao.deleteBatchIds(idList);
        System.out.println("删除的记录数："+rows);
    }


    // select
    /**
     * 根据id主键查询
     */
    @Test
    public void testSelectById(){

        User user = userDao.selectById(2);
        System.out.println(user);
    }

    /**
     * 根据id批量查询
     */
    @Test
    public void testSelectBatchIds(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<User> users = userDao.selectBatchIds(list);
        users.forEach(e -> System.out.println(e));
    }

    /**
     * 根据map的条件查询
     * 把要查询的条件字段put到Map，key是字段，value是字段值，多个条件是and连接。
     * 返回 list
     */
    @Test
    public void testSelectByMap(){
        Map<String, Object> param = new HashMap<>();
        param.put("name", "zhangsan");
        param.put("age", 25);

        List<User> users = userDao.selectByMap(param);
        System.out.println(users.size());
        users.forEach(e -> System.out.println(e));
    }




}

