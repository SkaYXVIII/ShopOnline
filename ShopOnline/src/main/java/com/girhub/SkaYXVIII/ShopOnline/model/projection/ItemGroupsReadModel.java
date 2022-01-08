package com.girhub.SkaYXVIII.ShopOnline.model.projection;

import com.girhub.SkaYXVIII.ShopOnline.model.ItemsGroup;

public class ItemGroupsReadModel {
    private String description;

    public ItemGroupsReadModel(ItemsGroup source) {
        this.description = source.getDescription();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
