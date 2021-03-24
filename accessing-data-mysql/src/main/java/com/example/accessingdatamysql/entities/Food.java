package com.example.accessingdatamysql.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "Food")
public class Food implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Food_Id")
    private Integer Id;

    @Column(name = "Name")
    private String Name;

    @Column(name="StartDate")
    private Date startTime;
    @Column(name="EndDate")
    private Date endTime;
    @Column(name="Price")
    private Integer price;
    @Column(name="Allergens")
    private String allergens;
    @Column(name="Ingredients")
    private String ingredients;

    @ManyToOne
    @JoinColumn(name = "FK_MenuId",referencedColumnName = "Menu_Id")
    private Menu menu;

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
