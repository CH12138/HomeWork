package com.jrx.springbootdemo.service.impl;

import com.jrx.springbootdemo.domain.Daily_sum_sta;
import com.jrx.springbootdemo.mapper.Daily_sum_staMapper;
import com.jrx.springbootdemo.service.Daily_sum_staService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: CH
 * @Date: 2020/6/11 19:30
 */

@Service
public class Daily_sum_staServiceImpl implements Daily_sum_staService {

    @Autowired
    private Daily_sum_staMapper daily_sum_staMapper;

    @Override
    public List<Daily_sum_sta> list() {
        return daily_sum_staMapper.list();
    }
}
