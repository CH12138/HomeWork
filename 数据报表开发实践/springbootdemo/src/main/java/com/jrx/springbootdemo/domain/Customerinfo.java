package com.jrx.springbootdemo.domain;

import io.swagger.annotations.ApiModel;

import java.sql.Date;

@ApiModel
public class Customerinfo {
    private int cust_id;

    private String surname;

    private String gender;

    private String educa_des;

    private String mar_des;

    private int birthday;

    private String address;
    public Customerinfo(){

    }

    public Customerinfo(int cust_id, String surname, String gender, String educa_des, String mar_des, int birthday, String address) {
        this.cust_id = cust_id;
        this.surname = surname;
        this.gender = gender;
        this.educa_des = educa_des;
        this.mar_des = mar_des;
        this.birthday = birthday;
        this.address = address;
    }

    public Integer getCust_id() {
        return cust_id;
    }

    public void setCust_id(Integer cust_id) {
        this.cust_id = cust_id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname == null ? null : surname.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEduca_des() {
        return educa_des;
    }

    public void setEduca_des(String educa_des) {
        this.educa_des = educa_des == null ? null : educa_des.trim();
    }

    public String getMar_des() {
        return mar_des;
    }

    public void setMar_des(String mar_des) {
        this.mar_des = mar_des == null ? null : mar_des.trim();
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    @Override
    public String toString() {
        return "Customerinfo{" +
                "cust_id=" + cust_id +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", educa_des='" + educa_des + '\'' +
                ", mar_des='" + mar_des + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }
}