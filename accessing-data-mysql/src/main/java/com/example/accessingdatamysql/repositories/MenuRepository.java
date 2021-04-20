package com.example.accessingdatamysql.repositories;

import com.example.accessingdatamysql.entities.Menu;
import com.example.accessingdatamysql.entities.Restaurant;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends CrudRepository<Menu,Integer> {

    @Modifying
    @Query("UPDATE Menu SET Name=:name WHERE Menu_Id=:id ")
    int updateMenuById(@Param(value = "id")Integer id,
                              @Param(value = "name")String name
    );

    @Query(value="SELECT * FROM Menu m WHERE m.FK_RestaurantId=:id", nativeQuery = true)
    List<Menu> findAllByFK_RestaurantId(@Param(value="id") Integer Id);


}
