package com.girhub.SkaYXVIII.ShopOnline.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "category")
public class ItemsGroup {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    @NotBlank(message = "Task group's description must not be empty")
    private String description;

    @Column(name = "parent", nullable = false)
    private int parent;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group", fetch = FetchType.EAGER)
    private Set<Item> items;

    public ItemsGroup() {
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

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }
}
