package com.datatrendspotter.datatrendspotter.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatasetRepository extends JpaRepository<Dataset, Long>{
    Dataset findByName(String name);
}
