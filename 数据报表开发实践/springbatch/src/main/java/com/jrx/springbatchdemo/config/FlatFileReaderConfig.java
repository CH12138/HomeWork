package com.jrx.springbatchdemo.config;

import com.jrx.springbatchdemo.model.Customerinfo;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

/**
 * @Author: CH
 * @Date: 2020/6/8 13:08
 */

@Configuration
public class FlatFileReaderConfig {
    @Bean
    public FlatFileItemReader<Customerinfo> flatFileReader() {
        FlatFileItemReader<Customerinfo> reader = new FlatFileItemReader<Customerinfo>();
        reader.setResource(new ClassPathResource("customer.txt"));
        reader.setLinesToSkip(1);//跳过第一行

        //从文件第二行开始进行数据解析
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();

        tokenizer.setNames(new String[]{"cust_id","surname","gender","educa_des","mar_des","birthday","address"});
        //把解析出的一行数据映射为对象
        DefaultLineMapper<Customerinfo> mapper = new DefaultLineMapper<Customerinfo>();
        mapper.setLineTokenizer(tokenizer);

        mapper.setFieldSetMapper(new FieldSetMapper<Customerinfo>() {
            @Override
            public Customerinfo mapFieldSet(FieldSet fieldSet) throws BindException {
                Customerinfo customerinfo = new Customerinfo();
                customerinfo.setCust_id(fieldSet.readInt("cust_id"));
                customerinfo.setSurname(fieldSet.readString("surname"));
                customerinfo.setGender(fieldSet.readString("gender"));
                customerinfo.setEduca_des(fieldSet.readString("educa_des"));
                customerinfo.setMar_des(fieldSet.readString("mar_des"));
                customerinfo.setBirthday(fieldSet.readString("birthday"));
                customerinfo.setAddress(fieldSet.readString("address"));
                return customerinfo;
            }
        });

        mapper.afterPropertiesSet();
        reader.setLineMapper(mapper);

        return reader;

    }
}
