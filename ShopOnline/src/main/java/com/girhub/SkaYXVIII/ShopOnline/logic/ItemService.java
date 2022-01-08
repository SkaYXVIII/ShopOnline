package com.girhub.SkaYXVIII.ShopOnline.logic;

import com.girhub.SkaYXVIII.ShopOnline.model.ItemRepository;
import com.girhub.SkaYXVIII.ShopOnline.model.projection.ItemReadModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }
    public List<ItemReadModel> readAll(){
        return repository.findAll().stream()
                .map(ItemReadModel::new)
                .collect(Collectors.toList());
    }
    public List<ItemReadModel> readById(int id){
        return repository.findById(id).stream()
                .filter(Objects::nonNull)
                .map(ItemReadModel::new)
                .collect(Collectors.toList());
    }

}
