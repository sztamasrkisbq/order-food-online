package com.example.accessingdatamysql.beans;

import com.example.accessingdatamysql.entities.Courier;
import com.example.accessingdatamysql.entities.Customer;
import com.example.accessingdatamysql.entities.Food;
import com.example.accessingdatamysql.entities.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderBean {
    private Integer id;
    private String name;
    private String phonenumber;
    private String email;
    private String address;
    private String description;
    private Customer customer;
    private Courier courier;

    private Map<Food,Integer> open;

    private Map<Food,Integer>getOpen(String open){
        //System.out.println(open);
        Map<Food,Integer> map =new HashMap<>();
        String[] days=open.split("\\|");
        for(Food f:id)
        {
            //System.out.println(s);
            String[] splits=s.split("_");
            map.put(splits[0],splits[1]);
        }
        return map;
    }


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
