package com.girhub.SkaYXVIII.ShopOnline.controller;

import com.girhub.SkaYXVIII.ShopOnline.logic.ItemService;
import com.girhub.SkaYXVIII.ShopOnline.model.Item;
import com.girhub.SkaYXVIII.ShopOnline.model.ItemForm;
import com.girhub.SkaYXVIII.ShopOnline.model.ItemRepository;
import com.girhub.SkaYXVIII.ShopOnline.model.projection.ItemReadModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/items")
public class ItemController {
    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
    private final ItemRepository repository;
    private final ItemService service;


    public ItemController(ItemRepository repository, ItemService service) {
        this.repository = repository;
        this.service = service;
    }

    @PostMapping()
    public ItemReadModel createItem(@RequestBody @Valid ItemForm form) {
        return new ItemReadModel(repository.save(service.registerItem(form)));
    }

    @GetMapping
    ResponseEntity<List<ItemReadModel>> showItems() {
        logger.warn("Exposing all the tasks!");
        return ResponseEntity.ok(service.readAll());
    }

    @GetMapping("/sorted")
    ResponseEntity<List<ItemReadModel>> showItemByPrice(@RequestParam float price) {
        if (service.readByPrice(price).isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(service.readByPrice(price));
    }


    @GetMapping("/{id}")
    ResponseEntity<List<ItemReadModel>> readItems(@PathVariable int id) {
        if (service.readById(id).isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(service.readById(id));
    }


    @PutMapping("/{id}")
    ResponseEntity<?> updateItems(@PathVariable int id, @RequestBody @Valid Item toUpdate) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .ifPresent(item -> {
                    item.updateFrom(toUpdate);
                    repository.save(item);
                });
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable("id") Integer id) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
