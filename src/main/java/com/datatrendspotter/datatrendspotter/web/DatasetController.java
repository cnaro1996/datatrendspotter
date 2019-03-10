package com.datatrendspotter.datatrendspotter.web;

import com.datatrendspotter.datatrendspotter.model.Dataset;
import com.datatrendspotter.datatrendspotter.model.DatasetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.crypto.Data;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class DatasetController {

    private final Logger log = LoggerFactory.getLogger(DatasetController.class);
    private DatasetRepository datasetRepository;

    public DatasetController(DatasetRepository datasetRepository) {
        this.datasetRepository = datasetRepository;
    }

    @GetMapping("/datasets")
    Collection<Dataset> datasets() {
        return datasetRepository.findAll();
    }

    @GetMapping("/dataset/{id}")
    ResponseEntity<?> getDataset(@PathVariable Long id){
        Optional<Dataset> dataset = datasetRepository.findById(id);
        return dataset.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/dataset")
    ResponseEntity<Dataset> createDataset(@Valid @RequestBody Dataset dataset) throws URISyntaxException {
        log.info("Request to create dataset: {}", dataset);
        Dataset result = datasetRepository.save(dataset);
        return ResponseEntity.created(new URI("/api/dataset/" + result.getId())).body(result);
    }

    @PutMapping("/dataset")
    ResponseEntity<Dataset> updateDataset(@Valid @RequestBody Dataset dataset) {
        log.info("Request to update dataset: {}", dataset);
        Dataset result = datasetRepository.save(dataset);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/dataset/{id}")
    public ResponseEntity<?> deleteDataset(@PathVariable Long id) {
        log.info("Request to delete dataset: {}", id);
        datasetRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
