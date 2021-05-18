package com.albert.plus;

import com.albert.plus.entity.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SuppressWarnings("all")
@SpringBootTest
class PlusApplicationARTests {

    /*@Autowired
    DeptMapper deptMapper;*/

    // 定义测试方法
    /**
     * 1、AR 之 insert
     *
     * 对象调用CRUD方法
     */
    @Test
    public void testARInsert(){
        Dept dept = new Dept();

        dept.setId(5);
        dept.setName("销售部5");
        dept.setMobile("105-1001");
        dept.setManager(2);

        boolean flag = dept.insert();
        System.out.println("AR Insert的结果："+flag);
    }

    /**
     * 2、AR 之 update
     *
     * 创建实体类对象，对要更新的属性值赋值，null的属性不更新，根据主键id更新记录。
     * 返回值是boolean，true表示更新成功；false表示更新失败。
     */
    @Test
    public void testARUpdateById(){
        Dept dept = new Dept();
        dept.setId(1);
        dept.setName("销售部1");
        // dept.setMobile("101-1001");
        // 没有赋值manager，null的属性值不更新

        boolean flag = dept.updateById();
        System.out.println("AR updateById的结果："+flag);
    }

    /**
     * 3、AR 之 delete
     *
     * 使用主键作为删除条件，deleteById的参数是主键值，sql语句的条件是where id=？
     *
     * 返回值始终是true
     * 删除返回值判断条件是result>=0，只要sql语法是正确的，返回就是true，与删除的记录条数无关。
     */
    @Test
    public void testARDelete(){
        Dept dept = new Dept();
        dept.setId(5);

        boolean flag = dept.deleteById();
        System.out.println("AR deleteById的结果"+flag);
    }

    /**
     * 4、AR 之 select
     *
     * 根据对象的id属性查询；
     * 不提供主键值会报错：selectById primaryKey is null.
     */
    @Test
    public void testARSelectById(){
        Dept dept = new Dept();
        dept.setId(1);

        Dept resultDept = dept.selectById();
        System.out.println("AR select的结果" + resultDept);

    }



}
