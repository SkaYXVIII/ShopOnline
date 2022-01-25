package com.girhub.SkaYXVIII.ShopOnline.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemsGroupRepository extends JpaRepository<ItemsGroup,Integer>{
    @Override
    List<ItemsGroup> findAll();
}
