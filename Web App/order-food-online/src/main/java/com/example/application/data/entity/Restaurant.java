package com.example.application.data.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Restaurant {
    private Integer id =null;
    private List<Menu> menus=null;
    private String name;
    private String address;
    private Map<String,String> open;
    private String phonenumber;
    private String email;
    private String password;

    public Restaurant() {
    }

    public Restaurant(String name, String address, Map<String, String> openHours, String phoneNum, String email, String password) {
        this.name = name;
        this.address = address;
        this.open = openHours;
        phonenumber = phoneNum;
        this.email = email;
        this.password = password;
    }

    public Restaurant(Integer id, String name, String address, Map<String, String> openHours, String phoneNum, String email, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.open = openHours;
        phonenumber = phoneNum;
        this.email = email;
        this.password = password;
    }

    public void addMenu(Menu m){
        if(menus==null){
        menus=new ArrayList<>();}
        menus.add(m);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phoneNum) {
        phonenumber = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Menu getLastmenu()
    {
        if(menus==null){
            return null;
        }else{
        return menus.get(menus.size()-1);}
    }
    public Menu getMenu(int slot)
    {
        return menus.get(slot);
    }

    public Map<String, String> getOpen() {
        return open;
    }

    public void setOpen(Map<String, String> openhours) {
        open = openhours;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "Id=" + id +
                ", Menus=" + menus +
                ", Name='" + name + '\'' +
                ", Address='" + address + '\'' +
                ", openHours=" + open +
                ", PhoneNum='" + phonenumber + '\'' +
                ", Email='" + email + '\'' +
                ", Password='" + password + '\'' +
                '}';
    }
}
