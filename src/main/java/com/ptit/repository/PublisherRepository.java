package com.ptit.repository;

import com.ptit.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    @Query("SELECT p FROM Publisher p WHERE CONCAT(p.name,'') LIKE %?1%")
    List<Publisher> findAllByN(String name);
}
