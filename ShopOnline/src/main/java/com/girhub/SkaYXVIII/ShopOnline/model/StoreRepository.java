package com.girhub.SkaYXVIII.ShopOnline.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store,Integer> {
    @Override
    List<Store> findAll();

    @Override
    Page<Store> findAll(Pageable page);

    @Override
    Optional<Store> findById(Integer id);

    List<Store> findByName(String name);

    @Override
    @Query(nativeQuery = true, value = "select count(*) > 0 from items where id=:id")
    boolean existsById(@Param("id") Integer id);

    @Override
    Store save(Store entity);
}
