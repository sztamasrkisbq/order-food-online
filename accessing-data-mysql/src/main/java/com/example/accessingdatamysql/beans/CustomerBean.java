package com.example.accessingdatamysql.beans;

import com.example.accessingdatamysql.entities.Customer;
import com.example.accessingdatamysql.entities.Food;
import com.example.accessingdatamysql.entities.Menu;

public class CustomerBean {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String phonenumber;
    private String address;


    public CustomerBean() {
    }

    public CustomerBean(Integer id, String name, String email, String password, String phonenumber, String address) {
        id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phonenumber = phonenumber;
        this.address = address;
    }

    public CustomerBean(Customer c) {
        id = c.getId();
        this.name = c.getName();
        this.email = c.getEmail();
        this.password = c.getPassword();
        this.phonenumber = c.getPhonenumber();
        this.address = c.getAddress();
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
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer toEntity(){
        Customer customer=new Customer();
        if(id!=null){
            customer.setId(this.id);
        }
        customer.setName(this.name);
        customer.setAddress(this.address);
        customer.setEmail(this.email);
        customer.setPassword(this.password);
        customer.setPhonenumber(this.phonenumber);
        return customer;
    }

    @Override
    public String toString() {
        return "CustomerBean{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phonenum='" + phonenumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
