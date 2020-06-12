package com.jrx.springbatchdemo.batch;

import com.jrx.springbatchdemo.model.Customerinfo;
import com.jrx.springbatchdemo.model.Transdetail;
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
 * @Date: 2020/6/8 13:00
 */

@Configuration
public class ItemWriterDbDemo {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;


    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    @Qualifier("flatFileReader")
    private ItemReader<? extends Customerinfo> flatFileReader;

    @Autowired
    @Qualifier("flatFileReader2")
    private ItemReader<? extends Transdetail> flatFileReader2;




    @Autowired
    @Qualifier("itemWriterDb")
    private ItemWriter<? super Customerinfo> itemWriterDb;

    @Autowired
    @Qualifier("itemWriterDb2")
    private ItemWriter<? super Transdetail> itemWriterDb2;

    @Bean
    public Job itemWriterDbDemoJob5(){
        return jobBuilderFactory.get("itemWriterDbDemoJob5")
                .start(itemWriterDbDemoStep3())
                .next(itemWriterDbDemoStep4())
                .build();
    }

    @Bean
    public Step itemWriterDbDemoStep4() {
        return stepBuilderFactory.get("itemWriterDbDemoStep4")
                .<Transdetail,Transdetail>chunk(10)
                .reader(flatFileReader2)
                .writer(itemWriterDb2)
                .build();
    }

    @Bean
    public Step itemWriterDbDemoStep3() {
        return stepBuilderFactory.get("itemWriterDbDemoStep3")
                .<Customerinfo,Customerinfo>chunk(10)
//                读取
                .reader(flatFileReader)
                .writer(itemWriterDb)
                .build();
    }
}
