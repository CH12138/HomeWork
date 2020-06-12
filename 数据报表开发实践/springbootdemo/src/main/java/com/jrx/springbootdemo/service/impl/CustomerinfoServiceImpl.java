package com.jrx.springbootdemo.service.impl;

import com.jrx.springbootdemo.domain.Customerinfo;
import com.jrx.springbootdemo.domain.Transdetail;
import com.jrx.springbootdemo.mapper.CustomerinfoMapper;
import com.jrx.springbootdemo.mapper.TransdetailMapper;
import com.jrx.springbootdemo.service.CustomerinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerinfoServiceImpl implements CustomerinfoService {

    @Autowired
    private CustomerinfoMapper customerinfoMapper;

    @Autowired
    private TransdetailMapper transdetailMapper;


    @Override
    public List<Customerinfo> findAllC() {
        return customerinfoMapper.list();
    }

    @Override
    public void insert(Customerinfo record) {
         customerinfoMapper.insert(record);
    }

    @Override
    public void update(Customerinfo customerinfo) {
        customerinfoMapper.updateByPrimaryKey(customerinfo);
    }

    @Override
    public void delete(int cust_id) {
        customerinfoMapper.deleteByPrimaryKey(cust_id);
    }


}
