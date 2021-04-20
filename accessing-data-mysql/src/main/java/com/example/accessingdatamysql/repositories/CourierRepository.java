package com.example.accessingdatamysql.repositories;

import com.example.accessingdatamysql.entities.Courier;
import org.springframework.data.repository.CrudRepository;

public interface CourierRepository extends CrudRepository<Courier, Integer> {
    Courier findByEmailAndPassword(String email, String password);
}
