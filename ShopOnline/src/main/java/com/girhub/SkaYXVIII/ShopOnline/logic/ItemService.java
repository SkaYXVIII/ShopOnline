package com.girhub.SkaYXVIII.ShopOnline.logic;

import com.girhub.SkaYXVIII.ShopOnline.model.*;
import com.girhub.SkaYXVIII.ShopOnline.model.projection.ItemReadModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;
    @Autowired
    private ItemsGroupRepository groupRepository;

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

    public Item registerItem(ItemForm form) {
        Item item = new Item();
        item.setName(form.getName());
        item.setDescription(form.getDescription());
        item.setPrice(form.getPrice());
        System.out.println(item.getId());
        item.setGroup(groupRepository.findById(form.getGroup()).orElse(null));
        System.out.println(item.getGroup().getId());

        return repository.save(item);
    }
}
