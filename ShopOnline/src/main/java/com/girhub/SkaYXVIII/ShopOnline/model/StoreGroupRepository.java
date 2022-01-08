package com.girhub.SkaYXVIII.ShopOnline.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreGroupRepository extends JpaRepository<StoreGroup,Integer>{
    @Override
    List<StoreGroup> findAll();
}
