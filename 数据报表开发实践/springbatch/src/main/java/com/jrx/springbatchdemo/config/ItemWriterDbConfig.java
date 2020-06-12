package com.jrx.springbatchdemo.config;

import com.jrx.springbatchdemo.model.Customerinfo;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author: CH
 * @Date: 2020/6/8 13:10
 */

@Configuration
public class ItemWriterDbConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public JdbcBatchItemWriter<Customerinfo> itemWriterDb(){
        JdbcBatchItemWriter<Customerinfo> writer = new JdbcBatchItemWriter<>();
        writer.setDataSource(dataSource);
        writer.setSql("insert into customerinfo (surname,gender,educa_des,mar_des,birthday,address)values (:surname,:gender,:educa_des,:mar_des,:birthday,:address)");
        //设置占位符替换
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        return writer;
    }
}
