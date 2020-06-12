package com.jrx.springbootdemo.mapper;

import com.jrx.springbootdemo.domain.Transdetail;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransdetailMapper {
    @Select("select * from Transdetail")
    List<Transdetail> list();

    @Delete("delete from transdetail where trans_id=#{cust_id}")
    void deleteByPrimaryKey(int trans_id);

    @Insert("insert into transdetail(cust_id,account,card_nbr,tranno,month_nbr,nill,trans_type,txn_datetime) values(#{cust_id},#{account},#{card_nbr},#{tranno},#{month_nbr},#{nill},#{trans_type},#{txn_datetime}")
    void insert(Transdetail record);

    @Update("update user set account=#{account},card_nbr=#{card_nbr},tranno=#{tranno},month_nbr=#{month_nbr},nill=#{nill},trans_type=#{trans_type},txn_datetime=#{txn_datetime} where cus_id=#{cust_id}")
    void  updateByPrimaryKey(Transdetail record);
}