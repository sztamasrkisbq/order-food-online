package com.example.application.data.entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private Integer Id;
    private String Name;
    List<Food> Foods;
    Integer Restid;

    public Menu(String name, Integer restId) {
        Name = name;
        this.Restid = restId;
    }

    public Menu(Integer id, String name, Integer restId) {
        Id = id;
        Name = name;
        this.Restid = restId;
    }

    public void addFood(Food f){
        Foods.add(f);
    }
    public Menu() {
    }

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

    public List<Food> getFoods() {
        return Foods;
    }

    public void setFoods(List<Food> foods) {
        this.Foods = foods;
    }

    public Integer getRestId() {
        return Restid;
    }

    public void setRestId(Integer restId) {
        this.Restid = restId;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", foods=" + Foods +
                ", restId=" + Restid +
                '}';
    }
}
