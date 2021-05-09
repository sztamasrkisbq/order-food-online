package com.example.accessingdatamysql.repositories;

import com.example.accessingdatamysql.entities.Menu;
import com.example.accessingdatamysql.entities.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    @Modifying
    @Query("UPDATE ORDER SET Status=:status WHERE Orderid=:id ")
    int updateStatusById(@Param(value = "id")Integer id,
                       @Param(value = "status")Integer status
    );

    @Modifying
    @Query("UPDATE ORDER SET Time=:time where Orderid=:id")
    int updateTimeById(@Param(value = "id")Integer id,
                       @Param(value = "time")Integer time
    );

    @Modifying
    @Query("UPDATE ORDER SET FK_CourierId=:Courier_Id where Orderid=:id")
    int addCourierById(@Param(value = "id") Integer id,
                       @Param(value = "Courier_Id") Integer c_id
    );

    @Query(value="SELECT * FROM Order o WHERE o.FK_CourierId=:id", nativeQuery = true)
    List<Order> GetOrdersByCourierID(@Param(value="id") Integer Id);
}
