package com.girhub.SkaYXVIII.ShopOnline.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Item always should have name!")
    private String name;

    @NotNull
    @Min(0)
    private float price;

    private String description;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category", referencedColumnName = "id", nullable = false)
    private ItemsGroup group;


    public Item() {
    }


    public void updateFrom(final Item source) {
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
