package com.ptit.service.impl;

import com.ptit.model.Store;
import com.ptit.repository.StoreRepository;
import com.ptit.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    @Override
    public Store update(Store store) {

        Store storeData = storeRepository.findOne(store.getId());

        if (!Objects.isNull(storeData)){
            storeData.setAmount(store.getAmount());
            storeData.setAuthor(store.getAuthor());
            storeData.setName(store.getName());
            storeData.setPrice(store.getPrice());
            storeRepository.save(storeData);
            return storeData;
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        storeRepository.delete(id);
    }

    @Override
    public Store findById(Long id) {
        return storeRepository.findOne(id);
    }

    @Override
    public Store create(Store store) {
        storeRepository.save(store);
        return store;
    }

    @Override
    public void updateStoreList(List<Store> stores) {

        for (Store store: stores){

            Store data = storeRepository.findOne(store.getId());
            data.setTotal(store.getTotal());
            data.setPrice(store.getPrice());
            data.setAmount(store.getAmount());
            storeRepository.save(data);
        }
    }
}
