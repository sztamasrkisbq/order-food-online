package com.example.accessingdatamysql.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Food")
public class Food implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Food_Id")
    private Integer Id;

    @Column(name = "Name")
    private String Name;

    @Column(name="Startdate")
    private LocalDate startDate;
    @Column(name="Enddate")
    private LocalDate endDate;
    @Column(name="Price")
    private Integer price;
    @Column(name="Allergens")
    private String allergens;
    @Column(name="Ingredients")
    private String ingredients;

    @ManyToOne
    @JoinColumn(name = "FK_Menuid",referencedColumnName = "Menu_Id")
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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
