package com.example.application.data.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private Integer id;
    private String name;
    List<Food> foods;
    Integer restaurantid;

    public Menu(String name, Integer restId) {
        this.name = name;
        this.restaurantid = restId;
    }

    public Menu(Integer id, String name, Integer restId) {
        this.id = id;
        this.name = name;
        this.restaurantid = restId;
    }

    public void addFood(Food f){
        if(foods==null){
        foods =new ArrayList<>();}
        foods.add(f);
    }
    public Menu() {
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

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public Integer getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(Integer restId) {
        this.restaurantid = restId;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "Id=" + id +
                ", Name='" + name + '\'' +
                ", foods=" + foods +
                ", restId=" + restaurantid +
                '}';
    }
}
