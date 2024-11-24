package com.example.Bikbaev4219;

import com.example.Bikbaev4219.entities.Treadmill;
import com.example.Bikbaev4219.persistence.TreadmillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private final TreadmillRepository repository;

    @Autowired
    public Runner(TreadmillRepository repository) {
        this.repository = repository;
    }

    private void doWeHaveSomethingInDb() {
        long count = repository.count();
        if (count > 0) {
            System.out.printf("Db has %d treadmills%n", count);
        } else {
            System.out.println("Db is empty");
        }
    }

    private String createTreadmillView(Treadmill treadmill) {
        return String.format("Treadmill(code: %s, model: %s)",
                treadmill.getCode(), treadmill.getModel());
    }

    private void printAllTreadmills() {
        Iterable<Treadmill> treadmills = repository.findAll();
        for (Treadmill treadmill : treadmills) {
            System.out.println(createTreadmillView(treadmill));
        }
    }


    @Override
    public void run(String... args) {

    }
}
