package com.example.accessingdatamysql.beans;

import com.example.accessingdatamysql.entities.Food;
import com.example.accessingdatamysql.entities.Menu;
import com.example.accessingdatamysql.entities.Restaurant;

import java.sql.Date;

public class FoodBean {
    private Integer id;
    private String name;
    private Date starttime;
    private Date endtime;
    private String allergens;
    private String ingredients;
    private Integer price;
    private Integer menuid;

    public FoodBean(Integer id, String name, Date startTime, Date endTime, String allergens, String ingredients, Integer price,Integer menuId) {
        id = id;
        this.name = name;
        this.starttime = startTime;
        this.endtime = endTime;
        this.allergens = allergens;
        this.ingredients = ingredients;
        this.price = price;
        this.menuid= menuId;
    }

    public FoodBean(Food f) {
        id = f.getId();
        this.name = f.getName();
        this.starttime = f.getStartTime();
        this.endtime = f.getEndTime();
        this.allergens = f.getAllergens();
        this.ingredients = f.getIngredients();
        this.price = f.getPrice();
        this.menuid=f.getMenu().getId();
    }
    public FoodBean() {
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuId) {
        this.menuid = menuId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date startTime) {
        this.starttime = startTime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endTime) {
        this.endtime = endTime;
    }

    public String getAllergens() {
        return allergens;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Food toEntity(Menu m){
        Food f=new Food();
        if(id!=null){
            f.setId(this.id);
        }
        f.setName(this.name);
        f.setStartTime(this.starttime);
        f.setEndTime(this.endtime);
        f.setPrice(this.price);
        f.setAllergens(this.allergens);
        f.setIngredients(this.ingredients);
        f.setMenu(m);
        return f;
    }

    @Override
    public String toString() {
        return "FoodBean{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", startTime=" + starttime +
                ", endTime=" + endtime +
                ", allergens='" + allergens + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", price=" + price +
                ", menuId=" + menuid +
                '}';
    }
}
