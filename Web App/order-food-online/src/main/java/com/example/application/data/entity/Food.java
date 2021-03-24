package com.example.application.data.entity;

import java.sql.Date;
import java.time.LocalDate;

public class Food {
    private Integer Id;
    private String Name;
    private Date Starttime;
    private Date Endtime;
    private String Allergens;
    private String Ingredients;
    private Integer Price;
    private Integer Menuid;

    public Food(String name, Date startTime, Date endTime, String Allergens, String ingredients, Integer price, Integer menuId) {
        Name = name;
        this.Starttime = startTime;
        this.Endtime = endTime;
        this.Allergens = Allergens;
        this.Ingredients = ingredients;
        this.Price = price;
        this.Menuid = menuId;
    }

    public Food() {
    }

    public Food(Integer id, String name, Date startTime, Date endTime, String Allergens, String ingredients, Integer price, Integer menuId) {
        Id = id;
        Name = name;
        this.Starttime = startTime;
        this.Endtime = endTime;
        this.Allergens = Allergens;
        this.Ingredients = ingredients;
        this.Price = price;
        this.Menuid = menuId;
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

    public Integer getMenuId() {
        return Menuid;
    }

    public void setMenuId(Integer menuId) {
        this.Menuid = menuId;
    }

    public Date getStartTime() {
        return Starttime;
    }

    public void setStartTime(Date startTime) {
        this.Starttime = startTime;
    }

    public Date getEndTime() {
        return Endtime;
    }

    public void setEndTime(Date endTime) {
        this.Endtime = endTime;
    }
    public LocalDate getStartTimeLocal() {
        return Starttime.toLocalDate();
    }

    public void setStartTime(LocalDate startTime) {
        this.Starttime = Date.valueOf(startTime);
    }

    public LocalDate getEndTimeLocal() {
        return Endtime.toLocalDate();
    }

    public void setEndTime(LocalDate endTime) {
        this.Endtime = Date.valueOf(endTime);
    }

    public String getAllergens() {
        return Allergens;
    }

    public void setAllergens(String Allergens) {
        this.Allergens = Allergens;
    }

    public String getIngredients() {
        return Ingredients;
    }

    public void setIngredients(String ingredients) {
        this.Ingredients = ingredients;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        this.Price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", startTime=" + Starttime +
                ", endTime=" + Endtime +
                ", allergens='" + Allergens + '\'' +
                ", ingredients='" + Ingredients + '\'' +
                ", price=" + Price +
                ", menuId=" + Menuid +
                '}';
    }
}
