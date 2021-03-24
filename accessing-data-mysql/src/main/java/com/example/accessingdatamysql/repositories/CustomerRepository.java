package com.example.accessingdatamysql.repositories;

import com.example.accessingdatamysql.entities.Customer;
import com.example.accessingdatamysql.entities.Menu;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {

    Customer findByEmailAndPassword(String email,String password);
}
