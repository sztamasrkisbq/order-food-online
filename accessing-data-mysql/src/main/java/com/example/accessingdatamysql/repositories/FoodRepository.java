package com.example.accessingdatamysql.repositories;

import com.example.accessingdatamysql.entities.Food;
import com.example.accessingdatamysql.entities.Menu;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface FoodRepository extends CrudRepository<Food,Integer> {

    @Modifying
    @Query("UPDATE Food SET Name=:name, StartTime=:start, EndTime=:end, Price=:price, Allergens=:allerg, Ingredients=:ingre, FK_MenuId=:menu WHERE Food_Id=:id ")
    int updateFoodById(@Param(value = "id")Integer id,
                              @Param(value = "name")String name,
                              @Param(value = "start") LocalDate start,
                              @Param(value = "end") LocalDate end,
                              @Param(value = "price")Integer price,
                              @Param(value = "allerg")String allerg,
                              @Param(value = "ingre")String ingre,
                              @Param(value = "menu")Integer menu

    );

    @Query(value ="SELECT * FROM Food f WHERE f.FK_MenuId=:id",nativeQuery = true)
    List<Food> findAllByFK_MenuId(@Param(value = "id") Integer Id);
}
