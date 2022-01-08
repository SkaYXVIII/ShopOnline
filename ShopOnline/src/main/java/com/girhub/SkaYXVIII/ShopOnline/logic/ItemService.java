package com.girhub.SkaYXVIII.ShopOnline.logic;

import com.girhub.SkaYXVIII.ShopOnline.model.StoreRepository;
import com.girhub.SkaYXVIII.ShopOnline.model.projection.ItemReadModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private StoreRepository repository;

    public ItemService(StoreRepository repository) {
        this.repository = repository;
    }
    public List<ItemReadModel> readAll(){
        return repository.findAll().stream()
                .map(ItemReadModel::new)
                .collect(Collectors.toList());
    }
}
