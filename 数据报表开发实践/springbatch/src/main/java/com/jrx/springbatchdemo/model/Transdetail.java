package com.jrx.springbatchdemo.model;

import java.math.BigDecimal;
import java.util.Date;


public class Transdetail {
    private Integer trans_id;

    private Integer cust_id;

    private String account;

    private String card_nbr;

    private Integer tranno;

    private Integer month_nbr;

    private BigDecimal bill;

    private String trans_type;

    private Date txn_datetime;

    public Integer getTrans_id() {
        return trans_id;
    }

    public void setTrans_id(Integer trans_id) {
        this.trans_id = trans_id;
    }

    public Integer getCust_id() {
        return cust_id;
    }

    public void setCust_id(Integer cust_id) {
        this.cust_id = cust_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getCard_nbr() {
        return card_nbr;
    }

    public void setCard_nbr(String card_nbr) {
        this.card_nbr = card_nbr == null ? null : card_nbr.trim();
    }

    public Integer getTranno() {
        return tranno;
    }

    public void setTranno(Integer tranno) {
        this.tranno = tranno;
    }

    public Integer getMonth_nbr() {
        return month_nbr;
    }

    public void setMonth_nbr(Integer month_nbr) {
        this.month_nbr = month_nbr;
    }

    public BigDecimal getBill() {
        return bill;
    }

    public void setBill(BigDecimal bill) {
        this.bill = bill;
    }

    public String getTrans_type() {
        return trans_type;
    }

    public void setTrans_type(String trans_type) {
        this.trans_type = trans_type == null ? null : trans_type.trim();
    }

    public Date getTxn_datetime() {
        return txn_datetime;
    }

    public void setTxn_datetime(Date txn_datetime) {
        this.txn_datetime = txn_datetime;
    }
}