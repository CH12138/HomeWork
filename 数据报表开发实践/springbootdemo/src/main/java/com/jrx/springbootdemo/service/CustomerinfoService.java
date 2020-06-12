package com.jrx.springbootdemo.service;

import com.jrx.springbootdemo.domain.Customerinfo;
import com.jrx.springbootdemo.domain.Transdetail;

import java.util.List;

public interface CustomerinfoService {

    List<Customerinfo> findAllC();

    void insert(Customerinfo record);

    void update(Customerinfo customerinfo);

    void delete(int cust_id);

}
