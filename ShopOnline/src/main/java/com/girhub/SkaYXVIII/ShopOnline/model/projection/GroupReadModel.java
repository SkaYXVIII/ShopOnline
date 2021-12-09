package com.girhub.SkaYXVIII.ShopOnline.model.projection;

import com.girhub.SkaYXVIII.ShopOnline.model.Store;
import com.girhub.SkaYXVIII.ShopOnline.model.StoreGroup;

import java.util.Set;

public class GroupReadModel {
    private int id;
    private String description;
    private Set<Store> items;

    public GroupReadModel(StoreGroup source) {
        id = source.getId();
        description = source.getDescription();
        items = source.getItems();
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

    public Set<Store> getItems() {
        return items;
    }

    public void setItems(Set<Store> items) {
        this.items = items;
    }
}
