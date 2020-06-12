package com.jrx.springbootdemo.controller;

import com.jrx.springbootdemo.domain.Transdetail;
import com.jrx.springbootdemo.service.TransdetailService;
import com.jrx.springbootdemo.util.MyResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: CH
 * @Date: 2020/6/11 13:45
 */

@CrossOrigin
@RestController//json格式
@Api(value = "交易信息接口")
public class TransdetailController {


    @Autowired
    TransdetailService transdetailService;

    @PostMapping("/transdetail/add")
    @ApiOperation(value="交易信息创建")
    public void createT(Transdetail transdetail){
        transdetailService.insert(transdetail);
    }


    @GetMapping("/transdetail/list")
    @ApiOperation(value="交易信息查询")
    public MyResponse<List<Transdetail>> listAll(){
//        @ApiParam(value = "客户名称") @RequestParam(required = false)String surname
        List<Transdetail> list = transdetailService.findAll();
//        System.out.println(Arrays.toString(list.toArray()));
//        MyResponse<List<Customerinfo>> myResponse = new MyResponse<>(list);
        MyResponse myResponse = new MyResponse();
        myResponse.setData(list);
        myResponse.setCode(202);
        myResponse.setMsg("成功");
        return myResponse;
    }

    @DeleteMapping("/transdetail/delete")
    @ApiOperation(value="交易信息删除")
    public void delete(int trans_id){
        transdetailService.delete(trans_id);
    }

    @PutMapping("/transdetail/update")
    @ApiOperation(value="交易信息更新")
    public void delete(Transdetail transdetail){
        transdetailService.update(transdetail);
    }

}
