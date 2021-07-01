package com.ptit.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "publishing")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity = Store.class)
    private Set<Store> stores;

    public Set<Store> getStores() {
        return stores;
    }

    public Publisher setStores(Set<Store> stores) {
        this.stores = stores;
        return this;
    }

    public Publisher(String name) {
        this.name = name;
    }

    public Publisher() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
