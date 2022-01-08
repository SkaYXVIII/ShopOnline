package com.girhub.SkaYXVIII.ShopOnline.controller;

import com.girhub.SkaYXVIII.ShopOnline.logic.ItemGroupService;
import com.girhub.SkaYXVIII.ShopOnline.model.ItemRepository;
import com.girhub.SkaYXVIII.ShopOnline.model.projection.GroupReadModel;
import com.girhub.SkaYXVIII.ShopOnline.model.projection.ItemReadModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/groups")
public class ItemsGroupController {
    private static final Logger logger = LoggerFactory.getLogger(ItemsGroupController.class);
    private final ItemGroupService service;
    private final ItemRepository repository;

    public ItemsGroupController(ItemGroupService service, ItemRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping
    ResponseEntity<List<GroupReadModel>> readAllGroups(){
        return ResponseEntity.ok(service.readAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<List<ItemReadModel>> readAllItemsFromGroup(@PathVariable int id){
        if (repository.findAllByGroup_Id(id).isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(repository.findAllByGroup_Id(id).stream()
                .map(ItemReadModel::new)
                .collect(Collectors.toList()));
    }


}
