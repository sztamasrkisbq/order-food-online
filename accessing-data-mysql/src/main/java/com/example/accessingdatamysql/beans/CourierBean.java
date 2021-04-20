package com.example.accessingdatamysql.beans;

import com.example.accessingdatamysql.entities.Courier;
import com.example.accessingdatamysql.entities.Food;

import java.sql.Date;

public class CourierBean {

    private Integer c_id;
    private String name;
    private String email;
    private String password;
    private String phonenumber;
    //private List<Order>

    public CourierBean() {

    }

    public CourierBean(Integer id, String name, String email, String password, String phonenumber) {
        id = c_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phonenumber = phonenumber;
    }

    public CourierBean(Courier c) {
        c_id = c.getId();
        this.name = c.getName();
        this.email = c.getEmail();
        this.password = c.getPassword();
        this.phonenumber = c.getPhonenumber();
    }

    public int getC_id() { return c_id; }
    public void setC_id(int c_id) { this.c_id = c_id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhonenumber() { return phonenumber; }
    public void setPhonenumber(String phonenumber) { this.phonenumber = phonenumber; }

    /*
    * addOrder function
    * */

    public Courier toEntity(){
        Courier c = new Courier();
        if(c_id != null){
            c.setId(this.c_id);
        }
        c.setId(this.c_id);
        c.setName(this.name);
        c.setEmail(this.email);
        c.setPassword(this.password);
        c.setPhonenumber(this.phonenumber);
        return c;
    }

    @Override
    public String toString() {
        return "CourierBean{" +
                "c_id=" + c_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }
}
