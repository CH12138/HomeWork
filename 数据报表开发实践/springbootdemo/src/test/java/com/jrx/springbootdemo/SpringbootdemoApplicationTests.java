package com.jrx.springbootdemo;

import com.jrx.springbootdemo.controller.CustomerInfoController;
import com.jrx.springbootdemo.domain.Customerinfo;
import com.jrx.springbootdemo.service.CustomerinfoService;
import com.jrx.springbootdemo.util.LogUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootdemoApplicationTests {
    @Autowired
    CustomerinfoService customerinfoService;

    @Autowired
    CustomerInfoController customerInfoController;

    @Test
    void contextLoads() {
    }
    @Test
    void test(){
        System.out.println( customerInfoController.list().getData().toString());
    }
    @Test
    void addTest(){
        Customerinfo customerinfo = new Customerinfo();
        customerinfo.setSurname("aaa");
        customerinfo.setAddress("上海");
        customerinfo.setBirthday(1998);
        customerinfo.setEduca_des("本科");
        customerinfo.setGender("女");
        customerinfo.setMar_des("未婚");
        try {
            customerinfoService.insert(customerinfo);
            System.out.println("插入成功");
        }catch(Exception e){
            System.out.println("插入失败");
        }
    }
    @Test
    void updateTest(){
        Customerinfo customerinfo = new Customerinfo(1,"b","男","博士","已婚",1998,"安徽");
        try {
            customerinfoService.update(customerinfo);
            System.out.println("更新成功");
        }catch(Exception e){
            System.out.println("更新失败");
        }
    }
    @Test
    void deleteTest(){
        int cuit_id=1;
        try {
            customerinfoService.delete(cuit_id);
            System.out.println("删除成功");
        }catch(Exception e){
            System.out.println("删除失败");
        }

    }
    @Test
    void selectTest(){
        try {
            List<Customerinfo> list = customerinfoService.findAllC();
            for(Customerinfo customerinfo:list){
                System.out.println(customerinfo.toString());
            }
            System.out.println("查询成功");
        }catch(Exception e){
            System.out.println("查询失败");
        }

    }


    @Test
    public void logTest() {
        Logger log = LogUtils.getExceptionLogger();
        Logger log1 = LogUtils.getBussinessLogger();
        Logger log2 = LogUtils.getDBLogger();
        log.error("getExceptionLogger===日志测试");
        log1.info("getBussinessLogger===日志测试");
        log2.debug("getDBLogger===日志测试");

    }





}
