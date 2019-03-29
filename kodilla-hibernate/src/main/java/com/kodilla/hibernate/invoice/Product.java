package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name="PRODUCTS")
public final class Product {
    private int id;
    private String name;
    private Item item;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

//    @Id
//    @GeneratedValue
//    @NotNull
//    @Column(name="PRODUCT_ID", unique = true)
//    public int getId() {
//        return id;
//    }
//
//    @NotNull
//    @Column(name="PRODUCT_NAME")
//    public String getName() {
//        return name;
//    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }


//@ManyToOne
//@JoinColumn(name="ITEMS_ITEM_ID")
    public Item getItem() {
        return item;
    }

    private void setItem(Item item) {
        this.item = item;
    }
}
