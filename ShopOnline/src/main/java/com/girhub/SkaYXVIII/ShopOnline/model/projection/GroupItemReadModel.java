package com.girhub.SkaYXVIII.ShopOnline.model.projection;


import com.girhub.SkaYXVIII.ShopOnline.model.Store;

public class GroupItemReadModel {
    private String description;

    public GroupItemReadModel(Store source) {
        description = source.getDescription();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
