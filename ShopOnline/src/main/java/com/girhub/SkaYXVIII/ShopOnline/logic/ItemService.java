package com.girhub.SkaYXVIII.ShopOnline.logic;

import com.girhub.SkaYXVIII.ShopOnline.model.Item;
import com.girhub.SkaYXVIII.ShopOnline.model.ItemRepository;
import com.girhub.SkaYXVIII.ShopOnline.model.ItemsGroup;
import com.girhub.SkaYXVIII.ShopOnline.model.ItemsGroupRepository;
import com.girhub.SkaYXVIII.ShopOnline.model.projection.ItemReadModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private ItemRepository repository;
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

    public Item connectToGroup(Item toCreate, int group_id) {
//        if (groupRepository.findById(group_id).isPresent()) {
//            ItemsGroup group = groupRepository.findById(group_id).get();
//            System.out.println(group.getDescription());
//            Item result = new Item(toCreate.getId(),
//                    toCreate.getName(),
//                    toCreate.getPrice(),
//                    toCreate.getDescription(),
//                    group);
//            return result;
//        }
        List<ItemsGroup> groups = groupRepository.findById(group_id).stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        if (groups.isEmpty()){
            return null;
        }
        return new Item(toCreate.getId(),
                toCreate.getName(),
                toCreate.getPrice(),
                toCreate.getDescription(),
                groups.get(0));
    }
}
