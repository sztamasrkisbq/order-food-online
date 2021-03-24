package com.example.application.data.entity;

public class Customer {
    private Integer id =null;
    private String name;
    private String phonenumber;
    private String email;
    private String password;
    private String address;

    public Customer(Integer id, String name, String phonenumber, String email, String password, String address) {
        this.id = id;
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.password = password;
        this.address = address;
    }
    public Customer (String name, String phonenumber, String email, String password, String address) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String Phonenumber) {
        phonenumber = Phonenumber;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id=" + id +
                ", Name='" + name + '\'' +
                ", PhoneNum='" + phonenumber + '\'' +
                ", Email='" + email + '\'' +
                ", Password='" + password + '\'' +
                ", Address='" + address + '\'' +
                '}';
    }
}
