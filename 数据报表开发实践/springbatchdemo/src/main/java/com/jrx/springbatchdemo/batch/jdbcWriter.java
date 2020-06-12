package com.jrx.springbatchdemo.batch;

import com.jrx.springbatchdemo.model.Daily_sum_sta;
import com.jrx.springbatchdemo.model.Transdetail;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author: CH
 * @Date: 2020/6/10 23:07
 */

/**
 * 将数据写入数据库
 */
@Configuration
public class jdbcWriter {
    @Autowired
    private DataSource dataSource;

    @Bean
    public JdbcBatchItemWriter<Daily_sum_sta> itemwriter(){
        JdbcBatchItemWriter<Daily_sum_sta> writer = new JdbcBatchItemWriter<>();
        writer.setDataSource(dataSource);
        writer.setSql("insert into Daily_sum_sta(s_index,cust_id,update_time,trans_date,surname,tran_max_amt,pay_amt,tran_cnt,pay_cnt,tran_amt) values (:s_index,:cust_id,:update_time,:trans_date,:surname,:tran_max_amt,:pay_amt,:tran_cnt,:pay_cnt,:tran_amt)");
        //设置占位符替换
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        return writer;
    }
}
