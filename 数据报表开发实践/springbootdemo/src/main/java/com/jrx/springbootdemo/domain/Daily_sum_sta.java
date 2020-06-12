package com.jrx.springbootdemo.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Daily_sum_sta {
    private String s_index;

    private Integer cust_id;

    private Date update_time;

    private Date trans_date;

    private String surname;

    private BigDecimal tran_max_amt;

    private BigDecimal pay_amt;

    private Integer tran_cnt;

    private Integer pay_cut;

    private BigDecimal tran_amt;

    public String getS_index() {
        return s_index;
    }

    public void setS_index(String s_index) {
        this.s_index = s_index == null ? null : s_index.trim();
    }

    public Integer getCust_id() {
        return cust_id;
    }

    public void setCust_id(Integer cust_id) {
        this.cust_id = cust_id;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getTrans_date() {
        return trans_date;
    }

    public void setTrans_date(Date trans_date) {
        this.trans_date = trans_date;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname == null ? null : surname.trim();
    }

    public BigDecimal getTran_max_amt() {
        return tran_max_amt;
    }

    public void setTran_max_amt(BigDecimal tran_max_amt) {
        this.tran_max_amt = tran_max_amt;
    }

    public BigDecimal getPay_amt() {
        return pay_amt;
    }

    public void setPay_amt(BigDecimal pay_amt) {
        this.pay_amt = pay_amt;
    }

    public Integer getTran_cnt() {
        return tran_cnt;
    }

    public void setTran_cnt(Integer tran_cnt) {
        this.tran_cnt = tran_cnt;
    }

    public Integer getPay_cut() {
        return pay_cut;
    }

    public void setPay_cut(Integer pay_cut) {
        this.pay_cut = pay_cut;
    }

    public BigDecimal getTran_amt() {
        return tran_amt;
    }

    public void setTran_amt(BigDecimal tran_amt) {
        this.tran_amt = tran_amt;
    }
}