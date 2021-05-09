package com.example.accessingdatamysql.repositories;

import com.example.accessingdatamysql.entities.Menu;
import com.example.accessingdatamysql.entities.Order;
import com.example.accessingdatamysql.entities.Sales;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SalesRepository extends CrudRepository<Sales, Integer> {

    @Query(value="SELECT * FROM Food f WHERE f.FK_FoodId=:id", nativeQuery = true)
    List<Menu> selectByFoodId(@Param(value="id") Integer Id);

    @Query(value="SELECT * FROM Sales s WHERE s.BeginDate=:begindate", nativeQuery = true)
    List<Menu> selectByBeginDate(@Param(value="begindate")LocalDate BeginDate);

}
