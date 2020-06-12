package com.jrx.springbootdemo.mapper;

import com.jrx.springbootdemo.domain.Daily_sum_sta;
import com.jrx.springbootdemo.domain.Transdetail;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Daily_sum_staMapper {


    @Select("select * from Daily_sum_sta")
    List<Daily_sum_sta> list();

}