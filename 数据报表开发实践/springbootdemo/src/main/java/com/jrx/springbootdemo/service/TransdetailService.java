package com.jrx.springbootdemo.service;

import com.jrx.springbootdemo.domain.Transdetail;

import java.util.List;

/**
 * @Author: CH
 * @Date: 2020/6/10 13:37
 */
public interface TransdetailService {

    List<Transdetail> findAll();

    void insert(Transdetail record);

    void delete(int trans_id);

    void update(Transdetail transdetail);
}
