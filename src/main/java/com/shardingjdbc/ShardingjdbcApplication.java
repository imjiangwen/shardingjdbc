package com.shardingjdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.shardingjdbc.mapper.**"})
public class ShardingjdbcApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShardingjdbcApplication.class, args);
  }

}
