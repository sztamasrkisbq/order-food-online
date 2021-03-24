package com.example.application.data.entity;

import java.util.List;
import java.util.Map;

public class Restaurant {
    private Integer Id=null;
    private List<Menu> Menus;
    private String Name;
    private String Address;
    private Map<String,String> open;
    private String Phonenumber;
    private String Email;
    private String Password;

    public Restaurant() {
    }

    public Restaurant(String name, String address, Map<String, String> openHours, String phoneNum, String email, String password) {
        Name = name;
        Address = address;
        this.open = openHours;
        Phonenumber = phoneNum;
        Email = email;
        Password = password;
    }

    public Restaurant(Integer id, String name, String address, Map<String, String> openHours, String phoneNum, String email, String password) {
        Id = id;
        Name = name;
        Address = address;
        this.open = openHours;
        Phonenumber = phoneNum;
        Email = email;
        Password = password;
    }

    public void addMenu(Menu m){
        Menus.add(m);
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String phoneNum) {
        Phonenumber = phoneNum;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
    public Menu getLastMenu()
    {
        return Menus.get(Menus.size());
    }
    public Menu getMenu(int slot)
    {
        return Menus.get(slot);
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
                "Id=" + Id +
                ", Menus=" + Menus +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", openHours=" + open +
                ", PhoneNum='" + Phonenumber + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
