package com.datatrendspotter.datatrendspotter;

import com.datatrendspotter.datatrendspotter.model.Dataset;
import com.datatrendspotter.datatrendspotter.model.DatasetRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * Extracts data from .xls file of Food Environment Atlas and loads it into the graph of our javascript page.
 */
@Component
public class Initializer implements CommandLineRunner{

    private final DatasetRepository repository;

    public Initializer(DatasetRepository repository){
        this.repository = repository;
    }

    @Override
    public void run(String... strings){
        Stream.of("Food Environment Atlas").forEach(name -> repository.save(new Dataset(name)));

        repository.findAll().forEach(System.out::println);


    }

}
