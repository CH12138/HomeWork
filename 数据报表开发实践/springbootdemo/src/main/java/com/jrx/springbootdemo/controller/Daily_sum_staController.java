package com.jrx.springbootdemo.controller;

import com.jrx.springbootdemo.domain.Customerinfo;
import com.jrx.springbootdemo.domain.Daily_sum_sta;
import com.jrx.springbootdemo.service.Daily_sum_staService;
import com.jrx.springbootdemo.util.MyResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: CH
 * @Date: 2020/6/11 19:32
 */

@CrossOrigin
@RestController//json格式
@Api(value = "客户信息接口")
public class Daily_sum_staController {

    @Autowired
    private Daily_sum_staService daily_sum_staService;

    @GetMapping("/daily/list")
    @ApiOperation(value="客户查询")
    public MyResponse<List<Daily_sum_sta>> list(){
        List<Daily_sum_sta> list = daily_sum_staService.list();
        MyResponse myResponse = new MyResponse();
        myResponse.setData(list);
        myResponse.setCode(202);
        myResponse.setMsg("成功");
        return myResponse;
    }
}
