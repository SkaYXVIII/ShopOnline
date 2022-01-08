package com.girhub.SkaYXVIII.ShopOnline.model.projection;

import com.girhub.SkaYXVIII.ShopOnline.model.StoreGroup;

import java.util.Set;
import java.util.stream.Collectors;

public class GroupReadModel {
    private int id;
    private String description;
    private Set<GroupItemReadModel> items;

    public GroupReadModel(StoreGroup source) {
        id = source.getId();
        description = source.getDescription();
        items = source.getItems().stream()
                .map(GroupItemReadModel::new)
                .collect(Collectors.toSet());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<GroupItemReadModel> getItems() {
        return items;
    }

    public void setItems(Set<GroupItemReadModel> items) {
        this.items = items;
    }
}
