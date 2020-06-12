package com.jrx.springbootdemo.controller;

import com.jrx.springbootdemo.domain.Customerinfo;
import com.jrx.springbootdemo.domain.Transdetail;
import com.jrx.springbootdemo.service.CustomerinfoService;
import com.jrx.springbootdemo.service.TransdetailService;
import com.jrx.springbootdemo.util.MyResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 客户表接口
 */
@CrossOrigin
@RestController
//json格式

@Api(value = "客户信息接口")
public class CustomerInfoController {

    @Autowired
    CustomerinfoService customerinfoService;


    @GetMapping("/customerinfo/list")
    @ApiOperation(value="客户查询")
    public MyResponse<List<Customerinfo>> list(){
        List<Customerinfo> list = customerinfoService.findAllC();
        MyResponse myResponse = new MyResponse();
        myResponse.setData(list);
        myResponse.setCode(202);
        myResponse.setMsg("成功");
        return myResponse;
    }
    @PostMapping("/customerinfo/add")
    @ApiOperation(value="客户创建")
    public void create(Customerinfo customerinfo){
        customerinfoService.insert(customerinfo);

    }
    @DeleteMapping("/customerinfo/delete")
    @ApiOperation(value="客户删除")
    public void delete(int cust_id){
        customerinfoService.delete(cust_id);
    }

    @PutMapping("/customerinfo/update")
    @ApiOperation(value="客户更新")
    public void update(Customerinfo customerinfo){
        customerinfoService.update(customerinfo);
    }


}
