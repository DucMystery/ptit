package com.ptit.model;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private Long price;

    @Column(name = "amount")
    private Long amount;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @Lazy
    private Publisher publisher;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Column(name = "total")
    private Long total;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }


    public Store(String name) {
        this.name = name;
    }

    public Store(String name, String author, Long price, Long amount, Publisher publisher, Long total) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.amount = amount;
        this.publisher = publisher;
        this.total = total;
    }

    public Store(String name, String author, Long price, Long amount,Long total) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.amount = amount;
        this.total = total;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Store() {
    }
}
