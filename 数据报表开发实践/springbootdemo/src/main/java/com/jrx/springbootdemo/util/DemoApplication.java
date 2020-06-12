package com.jrx.springbootdemo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@SpringBootApplication
@EnableTransactionManagement
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    @Qualifier("dataSource")
//    多种数据源注入方式
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("DATASOURCE = " + dataSource);
    }
}