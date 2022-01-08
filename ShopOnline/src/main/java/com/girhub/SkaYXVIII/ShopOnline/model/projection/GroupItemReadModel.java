package com.girhub.SkaYXVIII.ShopOnline.model.projection;


import com.girhub.SkaYXVIII.ShopOnline.model.Item;

public class GroupItemReadModel {
    private String description;

    public GroupItemReadModel(Item source) {
        description = source.getName();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
