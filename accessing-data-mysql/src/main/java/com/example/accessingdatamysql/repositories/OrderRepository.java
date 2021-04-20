package com.example.accessingdatamysql.repositories;

import com.example.accessingdatamysql.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
