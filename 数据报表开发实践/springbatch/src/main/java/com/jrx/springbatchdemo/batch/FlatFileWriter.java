package com.jrx.springbatchdemo.batch;

import com.jrx.springbatchdemo.model.Customerinfo;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: CH
 * @Date: 2020/6/8 11:52
 */

@Component("flatFileWriter")
public class FlatFileWriter implements ItemWriter<Customerinfo> {
    @Override
    public void write(List<? extends Customerinfo> items) throws Exception {
        for (Customerinfo customerinfo:items){
            System.out.println(customerinfo.toString());
        }
    }
}
