package org.example.repository;

import org.example.model.Laptop;
import org.springframework.stereotype.Repository;

@Repository // database CRUD operation
public class LaptopRepository {

    public void save(Laptop lap) {
        System.out.println("saving laptop object into database");

    }

}
