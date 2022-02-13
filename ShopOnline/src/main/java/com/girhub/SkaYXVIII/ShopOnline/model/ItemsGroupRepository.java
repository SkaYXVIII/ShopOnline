package com.girhub.SkaYXVIII.ShopOnline.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsGroupRepository extends JpaRepository<ItemsGroup, Integer> {
}
