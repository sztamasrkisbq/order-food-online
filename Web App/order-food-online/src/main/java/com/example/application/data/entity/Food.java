package com.example.application.data.entity;

import java.sql.Date;
import java.time.LocalDate;

public class Food {
    private Integer id;
    private String name;
    private Date starttime;
    private Date endtime;
    private String allergens;
    private String ingredients;
    private Integer price;
    private Integer menuid;

    public Food(String name, Date startTime, Date endTime, String Allergens, String ingredients, Integer price, Integer menuId) {
        this.name = name;
        this.starttime = startTime;
        this.endtime = endTime;
        this.allergens = Allergens;
        this.ingredients = ingredients;
        this.price = price;
        this.menuid = menuId;
    }

    public Food() {
    }

    public Food(Integer id, String name, Date startTime, Date endTime, String Allergens, String ingredients, Integer price, Integer menuId) {
        this.id = id;
        this.name = name;
        this.starttime = startTime;
        this.endtime = endTime;
        this.allergens = Allergens;
        this.ingredients = ingredients;
        this.price = price;
        this.menuid = menuId;
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

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuId) {
        this.menuid = menuId;
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
    public LocalDate getStartTimeLocal() {
        return starttime.toLocalDate();
    }

    public void setStartTime(LocalDate startTime) {
        this.starttime = Date.valueOf(startTime);
    }

    public LocalDate getEndTimeLocal() {
        return endtime.toLocalDate();
    }

    public void setEndTime(LocalDate endTime) {
        this.endtime = Date.valueOf(endTime);
    }

    public String getAllergens() {
        return allergens;
    }

    public void setAllergens(String Allergens) {
        this.allergens = Allergens;
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

    @Override
    public String toString() {
        return "Food{" +
                "Id=" + id +
                ", Name='" + name + '\'' +
                ", startTime=" + starttime +
                ", endTime=" + endtime +
                ", allergens='" + allergens + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", price=" + price +
                ", menuId=" + menuid +
                '}';
    }
}
