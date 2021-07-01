package com.ptit.service;

import com.ptit.model.Store;

import java.util.List;

public interface StoreService {

    List<Store> findAll();

    Store update(Store store);

    void delete(Long id);

    Store findById(Long id);

    Store create(Store store);

    void updateStoreList(List<Store> stores);
}
