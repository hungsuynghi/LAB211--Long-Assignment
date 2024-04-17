/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Fruit class representing a fruit entity.
 * Contains attributes such as ID, name, price, quantity, and origin.
 */
public class Fruit {
    String id, name;
    double price;
    int quantity;
    String origin;

    public Fruit() {
    }

    public Fruit(String id, String name, double price, int quantity, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    public double getAmount(){
        return quantity * price;
    }
    
    
    
    @Override
    public String toString() {
        return String.format("%-10s %-15s %-15s %-10s %-10s", id, name,price, quantity, origin);
    }
}
