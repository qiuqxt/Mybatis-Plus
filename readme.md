[Mybatis-Plus](https://mp.baomidou.com/guide/)

### 一、使用MP的步骤
 1. 新建 SpringBoot 工程
 2. 指定maven的MP坐标
```xml
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
        <version>Latest Version</version>
    </dependency>
```

指定数据库的驱动
```xml
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
```

 3. 创建实体类，1）定义属性，2）指定主键类型
 4. 创建Dao接口，需要继承BaseMapper<实体.class>
 5. 在springboot的启动类上，加入@MapperScan(value="指定Dao接口的包名")
 6. 测试使用：
    在测试类或Service注入Dao接口，框架实现动态代理创建Dao的实现类对象