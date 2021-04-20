package com.example.accessingdatamysql.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Order")
public class Order implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Order_Id")
    private Integer Id;

    @Column(name="Name")
    private String Name;
    @Column(name="Phone")
    private String Phone;
    @Column(name="Email")
    private String Email;
    @Column(name="Address")
    private String Address;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Column(name="Description")
    private String Description;


    @JoinColumn(name="FK_FoodId", referencedColumnName = "Food_Id")
    private String foods;

    @OneToOne
    @JoinColumn(name="FK_CourierId", referencedColumnName = "Courier_Id")
    private Courier courier;

    @ManyToOne
    @JoinColumn(name="FK_CustomerId", referencedColumnName = "Customer_Id")
    private Customer customer;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
