package com.jrx.springbatchdemo.config;

import com.jrx.springbatchdemo.model.Customerinfo;
import com.jrx.springbatchdemo.model.Transdetail;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.validation.BindException;

/**
 * @Author: CH
 * @Date: 2020/6/8 17:27
 */

@Configuration
public class FlatFileReaderConfig2 {
    @Bean
    public FlatFileItemReader<Transdetail> flatFileReader2() {
        FlatFileItemReader<Transdetail> reader = new FlatFileItemReader<Transdetail>();
        reader.setResource(new ClassPathResource("transdetail.txt"));
        reader.setLinesToSkip(1);//跳过第一行

        //从文件第二行开始进行数据解析
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();

        tokenizer.setNames(new String[]{"trans_id","cust_id","account","card_nbr","tranno","month_nbr","bill","trans_type","txn_datetime"});
        //把解析出的一行数据映射为对象
        DefaultLineMapper<Transdetail> mapper = new DefaultLineMapper<Transdetail>();
        mapper.setLineTokenizer(tokenizer);

        mapper.setFieldSetMapper(new FieldSetMapper<Transdetail>() {
            @Override
            public Transdetail mapFieldSet(FieldSet fieldSet) throws BindException {
                Transdetail transdetail = new Transdetail();
                transdetail.setTrans_id(fieldSet.readInt("trans_id"));
                transdetail.setCust_id(fieldSet.readInt("cust_id"));
                transdetail.setAccount(fieldSet.readString("account"));
                transdetail.setCard_nbr(fieldSet.readString("card_nbr"));
                transdetail.setTranno(fieldSet.readInt("tranno"));
                transdetail.setMonth_nbr(fieldSet.readInt("month_nbr"));
                transdetail.setBill(fieldSet.readBigDecimal("bill"));
                transdetail.setTrans_type(fieldSet.readString("trans_type"));
                transdetail.setTxn_datetime(fieldSet.readDate("txn_datetime"));
                return transdetail;
            }
        });

        mapper.afterPropertiesSet();
        reader.setLineMapper(mapper);

        return reader;

    }
}
