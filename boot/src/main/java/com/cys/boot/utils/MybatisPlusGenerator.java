/*package com.cys.boot.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Collections;

public class MybatisPlusGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/ssm?useUnicode=true&useSSL=false&characterEncoding=utf8", "root", "cys2022!")
                .globalConfig(builder -> {
                    builder.author("ChenYongSheng") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(System.getProperty("user.dir")+"/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.cys") // 设置父包名
                            .moduleName("boot") // 设置父包模块名
                            //.service("") // 设置自定义service路径,不设置就是默认路径
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir") +"/src/main/resources/mapper/")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_store") // 设置需要生成的表名
                            .addTablePrefix("t_")
                            // 设置自动填充的时间字段
                            .entityBuilder()//.addTableFills(
                             //       new Column("create_time", FieldFill.INSERT),new Column("update_time", FieldFill.INSERT_UPDATE))
                    ; // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
*/