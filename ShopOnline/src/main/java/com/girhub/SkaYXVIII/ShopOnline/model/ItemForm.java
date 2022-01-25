package com.girhub.SkaYXVIII.ShopOnline.model;


public class ItemForm {

    private String name;

    private float price;

    private String description;

    private int group;

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

    public int getGroup() {
        return group;
    }

    public int setGroup(int group) {
        this.group = group;
        return group;
    }
}
