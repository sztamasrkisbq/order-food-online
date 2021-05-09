package com.example.accessingdatamysql.beans;

import com.example.accessingdatamysql.entities.Food;
import com.example.accessingdatamysql.entities.Order;
import com.example.accessingdatamysql.entities.Restaurant;
import com.example.accessingdatamysql.entities.Sales;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SalesBean {
    private LocalDate begindate;
    private LocalDate enddate;

    public Restaurant getRs() {
        return rs;
    }

    public void setRs(Restaurant rs) {
        this.rs = rs;
    }

    private Restaurant rs;
    private Map<Food,Double> food_percentage;
    private Integer id;

    public SalesBean(List<Sales> s) {
        this.begindate = s.get(0).getBeginDate();
        this.enddate = s.get(0).getEndDate();
        this.rs = s.get(0).getRestaurants();
        for(Sales sale:s){
            food_percentage.put(sale.getFoods(),sale.getPercentage());
        }

    }
    public SalesBean() {
    }

    public LocalDate getBegindate() {
        return begindate;
    }

    public void setBegindate(LocalDate begindate) {
        this.begindate = begindate;
    }

    public LocalDate getEnddate() {
        return enddate;
    }

    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public List<Sales> toEntity(){
        ArrayList salesArray = new ArrayList();
        Sales s = new Sales();
        for(Map.Entry<Food,Double> asd:food_percentage.entrySet()){
        if(id != null){
            s.setId(this.id);
        }
        s.setBeginDate(this.begindate);
        s.setEndDate(this.enddate);
        s.setFoods(asd.getKey());
        s.setPercentage(asd.getValue());
        salesArray.add(s);
        }
        return salesArray;
    }
    @Override
    public String toString() {
        return "SalesBean{" +
                "begindate=" + begindate +
                ", enddate=" + enddate +
                ", food_percentage=" + food_percentage +
                ", id=" + id +
                '}';
    }
}
