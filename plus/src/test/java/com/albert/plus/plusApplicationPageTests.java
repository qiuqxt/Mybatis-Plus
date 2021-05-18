package com.albert.plus;

import com.albert.plus.entity.Student;
import com.albert.plus.mapper.StudentMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SuppressWarnings("all")
@SpringBootTest
public class plusApplicationPageTests {

    @Autowired
    StudentMapper studentMapper;

    // 3、分页
    @Test
    public void testPage(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.gt("age", 22)
                .orderByAsc("id");

        IPage<Student> page = new Page<>();
        page.setCurrent(1);
        page.setSize(3);

        IPage<Student> studentIPage = studentMapper.selectPage(page, qw);
        System.out.println("分页："+studentIPage);
        System.out.println("总页数："+studentIPage.getPages());
        System.out.println("总记录数："+studentIPage.getTotal());
        System.out.println("当前页码："+studentIPage.getCurrent());
        System.out.println("每页大小："+studentIPage.getSize());


    }
}
