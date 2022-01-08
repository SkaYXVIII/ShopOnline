package com.girhub.SkaYXVIII.ShopOnline.logic;

import com.girhub.SkaYXVIII.ShopOnline.model.StoreGroupRepository;
import com.girhub.SkaYXVIII.ShopOnline.model.projection.GroupReadModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreGroupService {
    private StoreGroupRepository repository;

    public StoreGroupService(StoreGroupRepository repository) {
        this.repository = repository;
    }
    public List<GroupReadModel> readAll(){
        return repository.findAll().stream()
                .map(GroupReadModel::new)
                .collect(Collectors.toList());
    }
}
