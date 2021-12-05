package com.girhub.SkaYXVIII.ShopOnline.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "items")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Item always should have name!")
    private String name;

    private float price;

    private String description;

    @ManyToOne
    @JoinColumn(name = "store_group_id")
    private StoreGroup group;

    public Store() {
    }

    public Store(int id, String name, float price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Store(int id, String name, float price, String description, StoreGroup group) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        if (group != null){
            this.group = group;
        }
    }

    public void updateFrom(final Store source){
        this.name = source.name;
        this.price = source.price;
        this.description = source.description;
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

    public StoreGroup getGroup() {
        return group;
    }

    public void setGroup(StoreGroup group) {
        this.group = group;
    }
}
