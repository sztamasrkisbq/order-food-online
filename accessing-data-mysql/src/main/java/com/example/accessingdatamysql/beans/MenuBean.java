package com.example.accessingdatamysql.beans;

import com.example.accessingdatamysql.entities.Menu;
import com.example.accessingdatamysql.entities.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class MenuBean {
    private Integer id;
    private String name;
    private List<FoodBean> foods=new ArrayList<>();
    private Integer restaurantid;

    public Integer getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(Integer restaurantid) {
        this.restaurantid = restaurantid;
    }

    public MenuBean(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public MenuBean() {
    }

    public MenuBean(Menu r) {
        this.id =r.getId();
        this.name=r.getName();
        this.restaurantid =r.getRestaurant().getId();
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

    public List<FoodBean> getFoods() {
        return foods;
    }

    public void setFoods(List<FoodBean> foods) {
        this.foods = foods;
    }

    public void addFood(FoodBean f){
        foods.add(f);
    }



    public Menu toEntity(Restaurant r){
        Menu m=new Menu();
        if(id !=null){
            m.setId(this.id);
        }
        m.setName(this.name);
        m.setRestaurant(r);
        return m;
    }

    @Override
    public String toString() {
        return "MenuBean{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", foods=" + foods +
                ", restaurantId=" + restaurantid +
                '}';
    }
}
