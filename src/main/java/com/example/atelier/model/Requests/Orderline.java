package com.example.atelier.model.Requests;

import com.example.atelier.model.Product.Product;

import javax.persistence.*;

@Entity(name = "Orderline")
@Table(name = "orderline")
public class Orderline {

    @Id
    @GeneratedValue
    int id;

    public Orderline() {
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getProductcount() {
        return productcount;
    }

    public int getBuy() {
        return buy;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product")
    Product product;

    int productcount;
    int buy;

    public Orderline(Product product, int productcount, int buy) {
        this.product = product;
        this.productcount = productcount;
        this.buy = buy;
    }
}
