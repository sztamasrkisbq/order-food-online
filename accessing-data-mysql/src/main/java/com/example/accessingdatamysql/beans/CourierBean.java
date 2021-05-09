package com.example.accessingdatamysql.beans;

import com.example.accessingdatamysql.entities.Courier;

import java.util.List;

public class CourierBean {

    private Integer id;
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;
    private String password;
    private String phonenumber;
    private List<OrderBean> listOfOrders;

    public CourierBean() {

    }

    public CourierBean(Integer id, String name, String email, String password, String phonenumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phonenumber = phonenumber;
    }

    public CourierBean(Courier c) {
        this.id = c.getCourierId();
        this.name = c.getName();
        this.email = c.getEmail();
        this.password = c.getPassword();
        this.phonenumber = c.getPhonenumber();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhonenumber() { return phonenumber; }
    public void setPhonenumber(String phonenumber) { this.phonenumber = phonenumber; }

    private void addOrder(OrderBean ob){

        listOfOrders.add(ob);
    }

    public Courier toEntity(){
        Courier c = new Courier();
        if(id != null){
            c.setCourierId(this.id);
        }
        c.setName(this.name);
        c.setEmail(this.email);
        c.setPassword(this.password);
        c.setPhonenumber(this.phonenumber);
        return c;
    }

    @Override
    public String toString() {
        return "CourierBean{" +
                "c_id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }
}
