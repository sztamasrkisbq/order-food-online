package com.example.accessingdatamysql.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="Salse")
public class Sales implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name="FK_FoodId", referencedColumnName = "Food_Id")
    private Food foods;

    @JoinColumn(name="R_RestId", referencedColumnName = "RestID")
    private Restaurant restaurants;

    @Column(name="percentage")
    private Double Percentage;

    @Column(name="BeginDate")
    private LocalDate BeginDate;
    @Column(name="EndDate")
    private LocalDate EndDate;


    public Restaurant getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Restaurant restaurants) {
        this.restaurants = restaurants;
    }

    public Double getPercentage() {
        return Percentage;
    }

    public void setPercentage(Double percentage) {
        Percentage = percentage;
    }

    public LocalDate getBeginDate() {
        return BeginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        BeginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return EndDate;
    }

    public void setEndDate(LocalDate endDate) {
        EndDate = endDate;
    }

    public Food getFoods() {
        return foods;
    }

    public void setFoods(Food foods) {
        this.foods = foods;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

