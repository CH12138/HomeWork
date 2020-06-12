package com.jrx.springbatchdemo.batch;

import com.jrx.springbatchdemo.model.Daily_sum_sta;
import com.jrx.springbatchdemo.util.Utiluuid;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: CH
 * @Date: 2020/6/10 22:32
 */


/*
dbcCursorItemReader是使用游标读取数据集的ItemReader实现类之一
JdbcCursorItemReader的执行过程有三步：
        通过DataSource创建JdbcTemplate
        设定数据集的SQL语句
        创建ResultSet到实体类的映射
        */
@Configuration
public class jdbcReader {

    @Bean
    public RowMapper<Daily_sum_sta> DailyEntityRowMapper() {

        return new RowMapper<Daily_sum_sta>() {
            public static final String CUST_COLUMN = "cust_id"; // 设置映射字段
            public static final String UPDATE_COLUMN = "update_time";
            public static final String TRANS_COLUMN = "trans_date";
            public static final String SURNAME_COLUMN = "surname";
            public static final String TRANMAX_COLUMN = "tran_max_amt";
            public static final String PAY_AMT_COLUMN = "pay_amt";
            public static final String TRAN_COLUMN = "tran_cnt";
            public static final String PAY_CUT_COLUMN = "pay_cnt";
            public static final String TRAN_AMT_COLUMN = "tran_amt";


            @Override
            // 数据转换
            public Daily_sum_sta mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Daily_sum_sta weatherEntity = new Daily_sum_sta();
                weatherEntity.setS_index(Utiluuid.getUuid());
                weatherEntity.setCust_id(resultSet.getInt(CUST_COLUMN));
                weatherEntity.setUpdate_time(resultSet.getDate(UPDATE_COLUMN));
                weatherEntity.setTrans_date(resultSet.getDate(TRANS_COLUMN));
                weatherEntity.setSurname(resultSet.getString(SURNAME_COLUMN));
                weatherEntity.setTran_max_amt(resultSet.getBigDecimal(TRANMAX_COLUMN));
                weatherEntity.setPay_amt(resultSet.getBigDecimal(PAY_AMT_COLUMN));

                weatherEntity.setTran_cnt(resultSet.getInt(TRAN_COLUMN));
                weatherEntity.setPay_cnt(resultSet.getInt(PAY_CUT_COLUMN));
                weatherEntity.setTran_amt(resultSet.getBigDecimal(TRAN_AMT_COLUMN));
                return weatherEntity;
            }
        };
    }

    @Bean
    public ItemReader<Daily_sum_sta> jdbcCursorItemReader(
            @Qualifier("DailyEntityRowMapper") RowMapper<Daily_sum_sta> rowMapper, DataSource datasource) {
        JdbcCursorItemReader<Daily_sum_sta> itemReader = new JdbcCursorItemReader<>();
        itemReader.setDataSource(datasource); //设置DataSource
        //设置读取的SQL
        itemReader.setSql("select a.*,ifnull(b.pay_amt,0) as pay_amt from \n" +
                "(select customerinfo.cust_id,now() as update_time,transdetail.txn_datetime as trans_date,customerinfo.surname,max(transdetail.bill) as tran_max_amt,sum(transdetail.bill) as tran_amt,sum(if(transdetail.trans_type='repay',1,0)) as pay_cnt ,sum(if(transdetail.trans_type='cosume',1,0)) as tran_cnt,if(transdetail.trans_type='repay',sum(transdetail.bill),sum(transdetail.bill)) as pay_ant\n" +
                " from customerinfo,transdetail where customerinfo.cust_id=transdetail.cust_id group by customerinfo.cust_id,transdetail.txn_datetime)a\n" +
                "left join(select cust_id,sum(bill) as pay_amt from transdetail where trans_type='repay' group by cust_id,txn_datetime)b on a.cust_id = b.cust_id;");
        itemReader.setRowMapper(rowMapper); //设置转换
        return itemReader;
    }
}
