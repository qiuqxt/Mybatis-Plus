package com.albert.plus;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * MP生成器
 */
public class AutoGenerate {
    public static void main(String[] args) {
        AutoGenerator mg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");    // H:\Java\Mybatis-Plus
        // 路径应该是：projectPath + "plus" + "/src/main/java/"
        gc.setOutputDir(projectPath + "/src/main/java/");
        gc.setAuthor("xt");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");

        mg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig db = new DataSourceConfig();
        db.setDriverName("com.mysql.cj.jdbc.Driver");
        db.setUrl("jdbc:mysql://localhost:3306/springdb");
        db.setUsername("root");
        db.setPassword("2580");

        mg.setDataSource(db);

        // package配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("plus");
        pc.setParent("/com/albert");
        mg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig sc = new StrategyConfig();
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        mg.setStrategy(sc);

        mg.execute();


    }
}
