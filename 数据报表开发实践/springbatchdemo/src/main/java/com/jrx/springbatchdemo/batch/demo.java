package com.jrx.springbatchdemo.batch;

import com.jrx.springbatchdemo.model.Daily_sum_sta;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: CH
 * @Date: 2020/6/10 23:00
 */

@Configuration
public class demo {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;


    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private ItemReader<? extends Daily_sum_sta> jdbcreader;

    @Autowired
    private ItemWriter<? extends Daily_sum_sta> jdbcwriter ;
    @Bean
    public Job itemWriterDbDemoJob21(){
        return jobBuilderFactory.get("itemWriterDbDemoJob21")
                .start(step())
                .build();
    }

    @Bean
    public Step step() {
        return stepBuilderFactory.get("step")
                .<Daily_sum_sta,Daily_sum_sta>chunk(2)
                .reader(jdbcreader)
                .writer((ItemWriter<? super Daily_sum_sta>) jdbcwriter)
                .faultTolerant()//开启容错处理
                .skip(Exception.class)//跳过异常
                .build();

    }

}
