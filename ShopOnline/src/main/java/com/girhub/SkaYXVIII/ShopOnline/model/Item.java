package com.girhub.SkaYXVIII.ShopOnline.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Item always should have name!")
    private String name;

    private float price;

    private String description;

    @ManyToOne
    @JoinColumn(name = "store_group_id")
    private ItemsGroup group;


    public Item() {
    }

    public Item(int id, String name, float price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Item(int id, String name, float price, String description, ItemsGroup group) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        if (group != null){
            this.group = group;
        }

    }

    public void updateFrom(final Item source){
        if (source.name != null) this.name = source.name;
        if (source.price != 0) this.price = source.price;
        if (source.description != null) this.description = source.description;
        if (source.group != null) this.group = source.group;
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

    public int getId() {
        return id;
    }

    public ItemsGroup getGroup() {
        return group;
    }

    public void setGroup(ItemsGroup group) {
        this.group = group;
    }
}
