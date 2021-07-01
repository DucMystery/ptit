package com.ptit.service.impl;

import com.ptit.model.Publisher;
import com.ptit.model.Store;
import com.ptit.repository.PublisherRepository;
import com.ptit.repository.StoreRepository;
import com.ptit.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Publisher create(Publisher publisher) {

        publisherRepository.save(publisher);
        return publisher;
    }

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher update(Publisher publisher) {

        Publisher publisherData = publisherRepository.findOne(publisher.getId());

        if (!Objects.isNull(publisherData)){
            publisherData.setName(publisher.getName());
            publisherData.setStores(publisher.getStores());
            publisherRepository.save(publisherData);
        }
        return publisherData;
    }

    @Override
    public void delete(Long id) {
        publisherRepository.delete(id);
    }

    @Override
    public Publisher findById(Long id) {

        Publisher publisher = publisherRepository.findOne(id);
        return publisher;
    }

    @Override
    public List<Publisher> findAllByName(String name) {

        List<Publisher> publishers = publisherRepository.findAllByN(name);
        if (publishers.size() == 0){
            Publisher publisher = new Publisher(name);
            publisherRepository.save(publisher);
            publishers.add(publisher);
        }
        return publishers;
    }

    @Override
    public List<Store> findAllStoreByName(String name, Long id) {

        List<Store> stores;
        stores = storeRepository.findAllStore(name, id);
        Publisher publisher = publisherRepository.findOne(id);
        if (stores.size() == 0) {
            Store store = new Store(name);
            store.setPublisher(publisher);
            storeRepository.save(store);
            stores.add(store);
        }
//        Publisher publisher = publisherRepository.findOne(id);
//
//        List<Store> stores = new ArrayList<>();
//        stores= (List<Store>) publisher.getStores();
//
//        if (stores.size() == 0){
//
//            Store store = new Store(name);
//            storeRepository.save(store);
//            stores.add(store);
//            publisher.setStores((Set<Store>) stores);
//            publisherRepository.save(publisher);
//        }else {
//            for (Store data : stores){
//                if (!data.getName().contains(name)){
//                    stores.remove(data);
//                }
//            }
//            publisher.setStores((Set<Store>) stores);
//        }
//        return publisher;
        return stores;
    }

}
