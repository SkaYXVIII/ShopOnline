package com.girhub.SkaYXVIII.ShopOnline.logic;

import com.girhub.SkaYXVIII.ShopOnline.model.Item;
import com.girhub.SkaYXVIII.ShopOnline.model.ItemForm;
import com.girhub.SkaYXVIII.ShopOnline.model.ItemRepository;
import com.girhub.SkaYXVIII.ShopOnline.model.ItemsGroupRepository;
import com.girhub.SkaYXVIII.ShopOnline.model.projection.ItemReadModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemRepository repository;
    private final ItemsGroupRepository groupRepository;

    public ItemService(ItemRepository repository, ItemsGroupRepository groupRepository) {
        this.repository = repository;
        this.groupRepository = groupRepository;
    }

    public List<ItemReadModel> readAll() {
        return repository.findAll().stream()
                .map(ItemReadModel::new)
                .collect(Collectors.toList());
    }

    public List<ItemReadModel> readById(int id) {
        return repository.findById(id).stream()
                .filter(Objects::nonNull)
                .map(ItemReadModel::new)
                .collect(Collectors.toList());
    }

    public List<ItemReadModel> readByPrice(float price) {
        //sortowanie można zrobić przez pageable
        return repository.findByPriceIsLessThanEqual(price).stream()
                .map(ItemReadModel::new)
                .sorted(ItemReadModel::compareTo)
                .collect(Collectors.toList());
    }

    public Item registerItem(ItemForm form) {
        Item item = new Item();
        item.setName(form.getName());
        item.setDescription(form.getDescription());
        item.setPrice(form.getPrice());
        item.setGroup(groupRepository.findById(form.getGroup()).orElse(null));
        return repository.save(item);
    }

    public ResponseEntity<?> updateItems(int id, Item toUpdate){
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

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
