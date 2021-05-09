package com.example.accessingdatamysql.repositories;

import com.example.accessingdatamysql.entities.Restaurant;
import com.example.accessingdatamysql.entities.Sorrend;
import org.springframework.data.repository.CrudRepository;

public interface SorrendRepository extends CrudRepository<Sorrend,Integer> {
    //updateOrder (egyedi update script)
}
