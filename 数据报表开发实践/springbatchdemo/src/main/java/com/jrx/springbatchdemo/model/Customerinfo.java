package com.jrx.springbatchdemo.model;

public class Customerinfo {
    private int cust_id;

    private String surname;

    private String gender;

    private String educa_des;

    private String mar_des;

    private String birthday;

    private String address;

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}