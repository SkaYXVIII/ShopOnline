package com.girhub.SkaYXVIII.ShopOnline.model.projection;

import com.girhub.SkaYXVIII.ShopOnline.model.Item;

public class ItemReadModel {
    private int id;

    private String name;

    private float price;

    private String description;

    private ItemGroupsReadModel group;

    public ItemReadModel(Item source){
        this.id = source.getId();
        this.name = source.getName();
        this.price = source.getPrice();
        this.description = source.getDescription();
        if (source.getGroup() != null){
            this.group =  new ItemGroupsReadModel(source.getGroup());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemGroupsReadModel getGroup() {
        return group;
    }

    public void setGroup(ItemGroupsReadModel group) {
        this.group = group;
    }
}
