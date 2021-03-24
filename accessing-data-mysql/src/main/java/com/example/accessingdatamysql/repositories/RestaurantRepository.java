package com.example.accessingdatamysql.repositories;

import com.example.accessingdatamysql.beans.RestaurantBean;
import com.example.accessingdatamysql.entities.Restaurant;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant,Integer> {

    @Modifying
    @Query("UPDATE Restaurant SET Name=:name, Address=:addr, Open=:open, PhoneNumber=:phoneNum, Email=:email WHERE Restaurant_Id=:id ")
    int updateRestaurantById(@Param(value = "id")Integer id,
                              @Param(value = "name")String name,
                              @Param(value = "addr")String addr,
                              @Param(value = "open")String open,
                              @Param(value = "phoneNum")String phoneNum,
                              @Param(value = "email")String email
                              );

    Restaurant findByEmailAndPassword(String Email,String Password);

}
