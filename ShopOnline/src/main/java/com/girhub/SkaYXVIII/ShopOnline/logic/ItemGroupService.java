package com.girhub.SkaYXVIII.ShopOnline.logic;

import com.girhub.SkaYXVIII.ShopOnline.model.ItemsGroupRepository;
import com.girhub.SkaYXVIII.ShopOnline.model.projection.GroupReadModel;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ItemGroupService {
    private ItemsGroupRepository repository;

    public ItemGroupService(ItemsGroupRepository repository) {
        this.repository = repository;
    }
    public List<GroupReadModel> readAll(){
        return repository.findAll().stream()
                .filter(Objects::nonNull)
                .map(GroupReadModel::new)
                .collect(Collectors.toList());
    }
}
