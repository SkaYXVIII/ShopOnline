package com.girhub.SkaYXVIII.ShopOnline.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store,Integer> {
    List<Store> findByName(String name);
    List<Store> findAllByGroup_Id(Integer groupId);
}
