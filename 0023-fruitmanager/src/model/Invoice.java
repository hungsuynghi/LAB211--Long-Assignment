/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.ManageFruit;
import java.util.ArrayList;

/**
 * The Invoice class represents an invoice containing customer information and a list of fruit orders.
 * It includes methods to add fruits to the invoice, calculate the total amount of the invoice, and retrieve
 * fruits from the list of fruit orders by ID.
 */

public class Invoice {
    
    private String customer;
    private ArrayList<Fruit> listFruitOrder = new ArrayList<>();
    ManageFruit manage = new ManageFruit();
    
    
    public Invoice() {
    }

    public Invoice(String customer, ArrayList<Fruit> listFruitOrder) {
        this.customer = customer;
        this.listFruitOrder = listFruitOrder;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public ArrayList<Fruit> getListFruitOrder() {
        return listFruitOrder;
    }

     /**
     * Getter method to retrieve the list of fruit orders in the invoice.
     * @return The list of fruit orders in the invoice.
     */
    public void setListFruitOrder(ArrayList<Fruit> listFruitOrder) {
        this.listFruitOrder = listFruitOrder;
    }
    
     /**
     * Adds a fruit to the list of fruit orders in the invoice.
     * If the fruit with the same ID already exists in the list, it updates the quantity of the existing fruit.
     * @param fruit The fruit to be added to the invoice.
     */
    public void addFruit(Fruit fruit) {
        Fruit fruitInList = getFruitInvoiceById(fruit.getId());
        if (fruitInList == null) {
            listFruitOrder.add(fruit);
        }else{
            fruitInList.setQuantity(fruitInList.getQuantity() + fruit.getQuantity());
        }
    }
    
    /**
     * Calculates and returns the total amount of the invoice based on the prices and quantities of the fruits.
     * @return The total amount of the invoice.
     */
    public double getTotalMoney(){
        double totalMoney = 0;
        for (Fruit fruit : listFruitOrder) {
            totalMoney += fruit.getAmount();
        }
        return totalMoney;
    }

    /**
     * Retrieves a fruit from the list of fruit orders in the invoice based on its ID.
     * @param id The ID of the fruit to retrieve.
     * @return The fruit with the specified ID, or null if not found.
     */
    private Fruit getFruitInvoiceById(String id) {
        for (Fruit fruit : listFruitOrder) {
            if (fruit.getId().equalsIgnoreCase(id)) {
                return fruit;
            }
        }
        return null;
    }




}
