package com.girhub.SkaYXVIII.ShopOnline.controller;

import com.girhub.SkaYXVIII.ShopOnline.logic.StoreGroupService;
import com.girhub.SkaYXVIII.ShopOnline.model.Store;
import com.girhub.SkaYXVIII.ShopOnline.model.StoreRepository;
import com.girhub.SkaYXVIII.ShopOnline.model.projection.GroupReadModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class StoreGroupController {
    private static final Logger logger = LoggerFactory.getLogger(StoreGroupController.class);
    private final StoreGroupService service;
    private final StoreRepository repository;

    public StoreGroupController(StoreGroupService service, StoreRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping
    ResponseEntity<List<GroupReadModel>> readAllGroups(){
        return ResponseEntity.ok(service.readAll());
    }

    //sprawdź czy to ma sens wgl
    @GetMapping("/{id}")
    ResponseEntity<List<Store>> readAllTasksFromGroup(@PathVariable int id){
        return ResponseEntity.ok(repository.findAllByGroup_Id(id));
    }


}
