package com.girhub.SkaYXVIII.ShopOnline.controller;

import com.girhub.SkaYXVIII.ShopOnline.model.Store;
import com.girhub.SkaYXVIII.ShopOnline.model.StoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/items")
public class StoreController {
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);
    private final StoreRepository repository;


    public StoreController(StoreRepository repository) {
        this.repository = repository;
    }
    //Pierwsza metoda wg udemy:
    @PostMapping
    ResponseEntity<Store> createItem(@RequestBody @Valid Store toCreate){
        Store result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }
    //Druga metoda wg random typa na githubie
//    @PostMapping
//    ResponseEntity<Store> createItem(@RequestBody @Valid Store toCreate){
//        HttpHeaders httpHeaders = new HttpHeaders();
//        if (toCreate == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        Store result = repository.save(toCreate);
//        return new ResponseEntity<>(result, httpHeaders, HttpStatus.CREATED);
//    }

    @GetMapping
    ResponseEntity<List<Store>> showStore() {
        logger.warn("Exposing all the tasks!");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Store> readStore(@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{name}")
    ResponseEntity<List<Store>> readStoreByName(@PathVariable String name) {
        List<Store> items = repository.findByName(name);
        if (items.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(items,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    ResponseEntity<?> updateStore(@PathVariable int id, @RequestBody @Valid Store toUpdate) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .ifPresent(task -> {
                    task.updateFrom(toUpdate);
                    repository.save(task);
                });
        return ResponseEntity.noContent().build();
    }
}
