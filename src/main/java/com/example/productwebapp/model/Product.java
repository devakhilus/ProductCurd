package com.example.productwebapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;

    // Default constructor for JPA
    public Product() {
        // Default constructor for JPA and other frameworks that use reflection
    }

    // Constructor to initialize name and price
    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    // Getter and setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for price
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // Override toString() for better readability in logging or debugging
    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', price=" + price + "}";
    }

    // Optionally, you can add validation for non-null fields if needed
    // Example: Validate that price is non-negative
    public boolean isValid() {
        return name != null && !name.isEmpty() && price != null && price >= 0;
    }
}
