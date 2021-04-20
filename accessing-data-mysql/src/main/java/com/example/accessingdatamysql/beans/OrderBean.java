package com.example.accessingdatamysql.beans;

import com.example.accessingdatamysql.entities.Courier;
import com.example.accessingdatamysql.entities.Customer;
import com.example.accessingdatamysql.entities.Order;

public class OrderBean {
    private Integer id;
    private String name;
    private String phonenumber;
    private String email;
    private String address;
    private String description;
    private Customer customer;
    private Courier courier;

    public OrderBean() {
    }

    public OrderBean(Integer id, String name, String phonenumber, String email, String address, String description, Customer customer, Courier courier) {
        this.id = id;
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.address = address;
        this.description = description;
        this.customer = customer;
        this.courier = courier;
    }
    public OrderBean(Order o){

    }
}
