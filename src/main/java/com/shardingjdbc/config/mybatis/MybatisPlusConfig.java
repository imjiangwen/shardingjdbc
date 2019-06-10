package com.shardingjdbc.config.mybatis;

import com.baomidou.mybatisplus.incrementer.H2KeyGenerator;
import com.baomidou.mybatisplus.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.mapper.ISqlInjector;
import com.baomidou.mybatisplus.mapper.LogicSqlInjector;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description : MybatisPlus配置
 */
@Configuration
public class MybatisPlusConfig {

  /***
   * plus 的性能优化
   * @return
   */
  @Bean
  public PerformanceInterceptor performanceInterceptor() {
    PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
    return performanceInterceptor;
  }

  /**
   * 分页插件
   */
  @Bean
  public PaginationInterceptor paginationInterceptor() {
    PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
    // 开启 PageHelper 的支持
    paginationInterceptor.setLocalPage(true);
    return paginationInterceptor;
  }

  /**
   * 注入主键生成器
   */
  @Bean
  public IKeyGenerator keyGenerator(){
    return new H2KeyGenerator();
  }

  /**
   * 注入sql注入器
   */
  @Bean
  public ISqlInjector sqlInjector(){
    return new LogicSqlInjector();
  }



}