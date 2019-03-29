package com.kodilla.hibernate.invoice;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ITEMS")
public class Item {
    private int id;
    private BigDecimal price;
    private int quantity;
    private BigDecimal value;
    private List<Product> products = new ArrayList<>();

    public Item() {
    }

    public Item(BigDecimal price, int quantity, BigDecimal value) {
        this.price = price;
        this.quantity = quantity;
        this.value = value;
    }


    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ITEM_ID")
    public int getId() {
        return id;
    }

    @Column(name = "ITEM_PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    @Column(name = "ITEM_QUANTITY")
    public int getQuantity() {
        return quantity;
    }

    @Column(name = "ITEM_VALUE")
    public BigDecimal getValue() {
        return value;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setPrice(BigDecimal price) {
        this.price = price;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private void setValue(BigDecimal value) {
        this.value = value;
    }

//    @OneToMany(
//            targetEntity = Product.class,
//            mappedBy = "Item",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    )
//    public List<Product> getProducts() {
//        return products;
//    }

    private void setProducts(List<Product> products) {
        this.products = products;
    }
}
