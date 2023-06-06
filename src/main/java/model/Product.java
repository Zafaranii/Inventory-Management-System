package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    private String supplier;
    private LocalDate production;
    private LocalDate expiration;
    private double price;
    private int quantity;


    public Product(String name, String type,double price, LocalDate expiration, LocalDate production, String supplier, int quantity) {
        this.name = name;
        this.type = type;
        this.supplier = supplier;
        this.production = production;
        this.expiration = expiration;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {

    }

    public void update(Product p)
    {
        name = p.name;
        type = p.type;
        supplier = p.supplier;
        production = p.production;
        expiration = p.expiration;
        price = p.price;
        quantity = p.quantity;
    }

}
