package com.jrx.springbootdemo.service.impl;

import com.jrx.springbootdemo.domain.Transdetail;
import com.jrx.springbootdemo.mapper.TransdetailMapper;
import com.jrx.springbootdemo.service.TransdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: CH
 * @Date: 2020/6/10 13:38
 */

@Service
public class TransdetailServiceImpl implements TransdetailService {

    @Autowired
    private TransdetailMapper transdetailMapper;

    @Override
    public List<Transdetail> findAll() {
        return transdetailMapper.list();
    }

    @Override
    public void insert(Transdetail record) {
         transdetailMapper.insert(record);
    }

    @Override
    public void delete(int trans_id) {
        transdetailMapper.deleteByPrimaryKey(trans_id);

    }

    @Override
    public void update(Transdetail transdetail) {
        transdetailMapper.updateByPrimaryKey(transdetail);
    }


}
