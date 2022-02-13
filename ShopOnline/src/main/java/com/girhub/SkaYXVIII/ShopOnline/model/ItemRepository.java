package com.girhub.SkaYXVIII.ShopOnline.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByName(String name);

    List<Item> findAllByGroup_Id(Integer groupId);

    Optional<Item> findById(Integer id);

    List<Item> findByPriceIsLessThanEqual(float price);

}
