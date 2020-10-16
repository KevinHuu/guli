package com.atguigu.eduService.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.atguigu.eduService.mapper")
public class EduConfig {
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }
}
