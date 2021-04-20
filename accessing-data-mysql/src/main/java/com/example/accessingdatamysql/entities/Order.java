package com.example.accessingdatamysql.entities;

import javax.persistence.*;
import java.io.Serializable;

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




}
