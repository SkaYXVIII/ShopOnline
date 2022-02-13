package com.girhub.SkaYXVIII.ShopOnline.model;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ItemForm {

    @NotBlank(message = "Item always should have name!")
    private String name;

    @NotNull
    @Min(0)
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
