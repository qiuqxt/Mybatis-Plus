package com.albert.plus;

import com.albert.plus.entity.Student;
import com.albert.plus.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SuppressWarnings("all")
@SpringBootTest
public class PlusApplicationSQLTests {

    @Autowired
    StudentMapper studentMapper;

    @Test
    public void testSelectByName(){

        List<Student> students = studentMapper.selectByName();
        students.forEach(e -> System.out.println(e));
    }

}
