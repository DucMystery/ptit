package com.ptit.dto;


import com.ptit.model.Store;

import java.util.List;

public class Cart {

    private Long total;

    private List<Store> stores;


    public Cart(Long total, List<Store> stores) {
        this.total = total;
        this.stores = stores;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cart(List<Store> stores) {
        this.stores = stores;
    }

    public Cart() {
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
}
