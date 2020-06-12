package com.jrx.springbootdemo.mapper;

import com.jrx.springbootdemo.domain.Customerinfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerinfoMapper {

    @Select("select * from customerinfo")
    List<Customerinfo> list();

    @Delete("delete from customerinfo where cust_id=#{cust_id}")
    void deleteByPrimaryKey(int cust_id);

    @Insert("insert into customerinfo(surname,gender,educa_des,mar_des,birthday,address) values(#{surname},#{gender},#{educa_des},#{mar_des},#{birthday},#{address})")
    void insert(Customerinfo record);

    @Update("update customerinfo set surname=#{surname},gender=#{gender},educa_des=#{educa_des},mar_des=#{mar_des},birthday=#{birthday},address=#{address} where cust_id=#{cust_id}")
    void  updateByPrimaryKey(Customerinfo record);



}