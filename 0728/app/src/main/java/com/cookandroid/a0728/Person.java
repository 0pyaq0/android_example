package com.cookandroid.a0728;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String gender;
    private String tel;
    private String address;

    Person(String name, String gender, String tel, String address){
        this.name=name;
        this.address=address;
        this.gender=gender;
        this.tel=tel;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getTel() {
        return tel;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }








}
