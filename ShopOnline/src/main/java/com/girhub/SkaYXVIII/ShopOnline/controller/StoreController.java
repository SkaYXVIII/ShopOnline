package com.girhub.SkaYXVIII.ShopOnline.controller;

import com.girhub.SkaYXVIII.ShopOnline.logic.ItemService;
import com.girhub.SkaYXVIII.ShopOnline.model.Store;
import com.girhub.SkaYXVIII.ShopOnline.model.StoreRepository;
import com.girhub.SkaYXVIII.ShopOnline.model.projection.ItemReadModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final ItemService service;


    public StoreController(StoreRepository repository, ItemService service) {
        this.repository = repository;
        this.service = service;
    }

    @PostMapping
    ResponseEntity<Store> createItem(@RequestBody @Valid Store toCreate){
        Store result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @GetMapping
    ResponseEntity<List<ItemReadModel>> showStore() {
        logger.warn("Exposing all the tasks!");
        System.out.println(service.readAll().toString());
        if (service.readAll() == null){
            System.out.println("tutaj");
        }

        return ResponseEntity.ok(service.readAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Store> readStore(@PathVariable int id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



    @PutMapping("/{id}")
    ResponseEntity<?> updateStore(@PathVariable int id, @RequestBody @Valid Store toUpdate) {
        if (!repository.existsById(id)) {
            System.out.println("tutaj");
            return ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .ifPresent(task -> {
                    System.out.println("tutaj2");
                    task.updateFrom(toUpdate);
                    repository.save(task);
                });
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Store> deleteCustomer(@PathVariable("id")Integer id) {
        Store store = repository.getById(id);

        if (store == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
