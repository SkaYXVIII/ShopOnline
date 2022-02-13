package com.girhub.SkaYXVIII.ShopOnline.controller;

import com.girhub.SkaYXVIII.ShopOnline.model.Item;
import com.girhub.SkaYXVIII.ShopOnline.model.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Jak narazie nie wykorzystany kontroler
@RestController
@RequestMapping("/search")
public class SearchController {
    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
    private final ItemRepository repository;

    public SearchController(ItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{name}")
    ResponseEntity<List<Item>> readStoreByName(@PathVariable String name) {
        List<Item> items = repository.findByName(name);
        if (items.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
