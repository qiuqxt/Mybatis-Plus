package com.albert.plus;

import com.albert.plus.entity.Student;
import com.albert.plus.mapper.StudentMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SuppressWarnings("all")
@SpringBootTest
public class PlusApplicationWrapperTests {

    @Autowired
    StudentMapper studentMapper;
    /**
     * 1、allEq：以Map为参数条件
     * a）条件
     */
    @Test
    public void testAllEq(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        Map<String, Object> param = new HashMap<>();
        param.put("name", "zhangsan");
        param.put("age", 20);
        qw.allEq(param);

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    /**
     * 1、allEq
     * 查询条件有null
     */
    @Test
    public void testAllEq2(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        Map<String, Object> param = new HashMap<>();
        param.put("name", "zhangsan");
        param.put("age", null);
        qw.allEq(param, true);
        //qw.allEq(param, false);

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    /**
     * 2、eq
     */
    @Test
    public void testEq(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.eq("name", "zhangsan");

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    /**
     * 3、ne
     */
    @Test
    public void testNe(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.ne("name", "zhangsan");

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    /**
     * 4、gt
     */
    @Test
    public void testGt(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.gt("age", 20);

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    /**
     * 5、ge
     */
    @Test
    public void testGe(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.ge("age", 20);

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    /**
     * 6、lt
     */
    @Test
    public void testLt(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.lt("age", 22);

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    /**
     * 7、le
     */
    @Test
    public void testLe(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.le("age", 22);

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    /**
     * 8、between
     */
    @Test
    public void testBetween(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.between("age", 21,23);

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    /**
     * 9、notBetween
     */
    @Test
    public void testNotBetween(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.notBetween("age", 21,23);

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    /**
     * 10、like
     */
    @Test
    public void testLike(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.like("name", "zh");

        List<Student> students = studentMapper.selectList(qw);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    /**
     * 10、notLike
     */
    @Test
    public void testNotLike(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.notLike("name", "zh");
        //qw.notLike(false,"name", "zh");

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    /**
     * 11、likeLeft
     */
    @Test
    public void testLikeLeft(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.likeLeft("name", "i");

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    /**
     * 11、likeRight
     */
    @Test
    public void testLikeRight(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.likeRight("name", "l");

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }


    /**
     * 12、isNull
     */
    @Test
    public void testIsNull(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.isNull("name");

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    /**
     * 12、isNotNull
     */
    @Test
    public void testIsNotNull(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.isNotNull("name");

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    /**
     * 13、in
     */
    @Test
    public void testIn(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        qw.in("age", 20, 21, 22);

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    /**
     * 13、notIn
     */
    @Test
    public void testNotIn(){
        QueryWrapper<Student> qw = new QueryWrapper<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        qw.notIn("status", list);

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    /**
     * 14、inSql
     * 常用来做子查询，类似 in()
     */
    @Test
    public void testInSql(){
        QueryWrapper<Student> qw = new QueryWrapper<>();

        qw.inSql("age", "select age from tbl_student where id in (1,2)");

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    /**
     * 14、notInSql
     * 类似于 notIn()
     */
    @Test
    public void testNotInSql(){
        QueryWrapper<Student> qw = new QueryWrapper<>();

        qw.notInSql("age", "select age from tbl_student where id in (1,2)");

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    /**
     * 15、groupBy
     */
    @Test
    public void testGroupBy(){
        QueryWrapper<Student> qw = new QueryWrapper<>();

        qw.select("status,count(*) personNumbers");
        qw.groupBy("status");

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    /**
     * 16、orderBy
     *
     * orderByAsc：按字段升序
     * orderByDesc：按字段降序
     */
    @Test
    public void testOrderByAsc(){
        QueryWrapper<Student> qw = new QueryWrapper<>();

        qw.orderByAsc("name");

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    @Test
    public void testOrderByDesc(){
        QueryWrapper<Student> qw = new QueryWrapper<>();

        qw.orderByDesc("age");

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    /**
     * 17、or，and
     *
     * or：连接条件用 or()
     * 默认是 and
     */
    @Test
    public void testOr(){
        QueryWrapper<Student> qw = new QueryWrapper<>();

        qw.eq("age", 20)
                .or()
                .eq("age", 21);

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    @Test
    public void testAnd(){
        QueryWrapper<Student> qw = new QueryWrapper<>();

        qw.eq("age",25).isNotNull("name");

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    /**
     * 18、last
     *
     * last拼接sql语句
     */
    @Test
    public void testLast(){
        QueryWrapper<Student> qw = new QueryWrapper<>();

        qw.between("age", 20,23)
                .or()
                .eq("age", 26)
                .last("limit 2");

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }

    /**
     * 19、exists，notExists
     *
     * exists拼接sql语句
     */
    @Test
    public void testExists(){
        QueryWrapper<Student> qw = new QueryWrapper<>();

        qw.exists("select id from tbl_student where age > 20");

        List<Student> students = studentMapper.selectList(qw);
        students.forEach(e -> System.out.println(e));
    }


}
