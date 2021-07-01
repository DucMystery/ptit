package com.ptit.repository;

import com.ptit.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {

    @Query("select s from Store s where lower(s.name) like lower(concat('%', :name, '%')) and s.publisher.id like :id")
    List<Store> findAllStore(@Param("name") String name, @Param("id") Long id);
}
