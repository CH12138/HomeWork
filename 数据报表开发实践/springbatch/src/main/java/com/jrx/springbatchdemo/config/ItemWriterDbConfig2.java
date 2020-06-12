package com.jrx.springbatchdemo.config;

import com.jrx.springbatchdemo.model.Customerinfo;
import com.jrx.springbatchdemo.model.Transdetail;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author: CH
 * @Date: 2020/6/8 17:37
 */

@Configuration
public class ItemWriterDbConfig2 {
    @Autowired
    private DataSource dataSource;

    @Bean
    public JdbcBatchItemWriter<Transdetail> itemWriterDb2(){
        JdbcBatchItemWriter<Transdetail> writer = new JdbcBatchItemWriter<>();
        writer.setDataSource(dataSource);
        writer.setSql("insert into transdetail(cust_id,account,card_nbr,tranno,month_nbr,bill,trans_type,txn_datetime) values (:cust_id,:account,:card_nbr,:tranno,:month_nbr,:bill,:trans_type,:txn_datetime)");
        //设置占位符替换
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        return writer;
    }
}
