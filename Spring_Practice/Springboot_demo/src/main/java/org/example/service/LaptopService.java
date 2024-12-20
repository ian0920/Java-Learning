package org.example.service;

import org.example.model.Laptop;
import org.example.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Business logic execution
public class LaptopService {

    @Autowired
    private LaptopRepository lapRepo;




    public void addLaptop(Laptop lap) {
        lapRepo.save(lap);// doing the business logic here
    }


}
