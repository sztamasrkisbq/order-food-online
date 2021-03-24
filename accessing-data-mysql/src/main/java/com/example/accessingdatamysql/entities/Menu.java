package com.example.accessingdatamysql.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Menu")

public class Menu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Menu_Id")
    private Integer Id;

    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "FK_Restaurantid",referencedColumnName = "Restaurant_Id")
    private Restaurant restaurant;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


}
