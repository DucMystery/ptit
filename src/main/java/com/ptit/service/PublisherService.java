package com.ptit.service;

import com.ptit.model.Publisher;
import com.ptit.model.Store;

import java.util.List;
import java.util.Set;

public interface PublisherService {

    Publisher create(Publisher publisher);

    List<Publisher> findAll();

    Publisher update(Publisher publisher);

    void delete(Long id);

    Publisher findById(Long id);

    List<Publisher> findAllByName(String name);

    List<Store> findAllStoreByName(String name, Long id);
}
