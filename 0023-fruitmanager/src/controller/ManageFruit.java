/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;

import model.Fruit;
import model.Invoice;
import utility.Utility;

/**
 *
 * Manages fruit-related operations and maintains lists of fruits and invoices.
 */
public class ManageFruit {
    // ArrayList to store fruits
    public ArrayList<Fruit> fruitList = new ArrayList<>();
    // ArrayList to store invoices
    public ArrayList<Invoice> invoiceList = new ArrayList<>();
    // Utility instance for handling input
    Utility utility = new Utility();
    
    /**
     * Adds a new fruit to the fruitList.
     * @param fruit The fruit to be added.
     */
    public void addFruit(Fruit fruit){
        fruitList.add(fruit);
    }
    
    
    /**
     * Checks for duplicate fruits based on their IDs.
     * @param id The ID to be checked for duplication.
     * @return True if a duplicate is found, false otherwise.
     */
    public boolean checkDuplicate(String id) {
        //flag to mark duplicate test results
        boolean flag = true;
        //loop through the studentList to check for duplicates based on ID
        for (Fruit fruit : fruitList) {
            if (fruit.getId().equalsIgnoreCase(id)) {
                //Set the flag to true if a duplicate is found
                
                return flag;
            }
        }
        //Return false if no duplicate is found
        return !flag ;
    }
    
    
    /**
    * Prompts the user for a yes/no input to determine continuation.
    * @return True if the user wants to continue, false otherwise.
    */
    public boolean checkYesNo() {
        //flag to mark duplicate test results
        boolean flag = true;
        //let user for input and validate using the utility getString method.
        String result = utility.getString("Do you want to continue? (y/n)", "Error", utility.REGEX_YESNO);
        //Check if the user's input is 'y' (case-insensitive)
        if (result.equalsIgnoreCase("y")) {
            //Set the flag to true if the user wants to continue.
            return flag;//Return true to indicate the user's choice.
        }else{
            return !flag;//// Return false if the user does not want to continue.
        }
    }
    
    
    /**
    * Displays the list of fruits 
    * @param fruitList The list of fruits to be displayed.
    */
    public void displayListFruit(ArrayList<Fruit> fruitList){
        System.out.format("%-10s %-15s %-15s %-10s %-10s\n", "Item", "Name","Price", "Quantity", "Origin");
        // loop through each fruit in the list
        for (Fruit fruit : fruitList) {
             // Print fruit
            System.out.println(fruit);
        }
    }
    /**
    * Manages the process of shopping for fruits.
    * This method allows the user to select fruits, specify quantities, and generate an invoice.
    * The user can continue shopping until they choose to stop or the shop runs out of stock.
    */
    public void shoppingFruit() {
        
        
        // Create a new invoice for the shopping session
         Invoice invoice = new Invoice();
        Fruit fruitChoice;
        while (true) {      
             // Display the list of available fruits
            displayListFruit(fruitList); 
        
            while (true) {  
                // Prompt the user to enter the item they want to purchase
                String item = utility.getString("Enter item: ", "Invalid input", utility.REGEX_STRING);
                // Retrieve the selected fruit based on the entered item
                fruitChoice = getFruitById(item);
                // Check if the entered item exists in the list of available fruits
                if (!checkIdExist(item)) {
                    System.out.println("wrong item, choose again");
                }else{
                    // Display the name of the selected fruit
                    System.out.println("You selected: " + fruitChoice.getName());
                    break;
                }
            }

            // Prompt the user to enter the quantity of the selected fruit
            int quantityOrder = utility.getInteger("Enter quantity: ", "Invalid input", 0, fruitChoice.getQuantity());

            // Update the remaining quantity of the selected fruit
            fruitChoice.setQuantity(fruitChoice.getQuantity() - quantityOrder);
            
            
            // Remove the fruit from the available list if it runs out of stock
            if (fruitChoice.getQuantity() == 0) {
                fruitList.remove(fruitChoice);
            }
            
            // Create a new Fruit object representing the ordered fruit 
            Fruit fruitOrder = new Fruit(fruitChoice.getId(), fruitChoice.getName(), fruitChoice.getPrice(), quantityOrder, fruitChoice.getOrigin());
            //add fruit order to invoice
            
            invoice.addFruit(fruitOrder);

            // Check if the user wants to continue shopping
            if (!checkYesNo()) {
                
                break;
            }
             // Check if the shop is out of stock
            if (fruitList.isEmpty()) {
                System.out.println("Out of stock");
                break;
            }
        }
        // Display the invoice details
        System.out.format("%-10s %-15s %-15s %-10s\n", "Product", "Quantity","Price", "Amount");
        for (Fruit fruit : invoice.getListFruitOrder()) {
            System.out.format("%-10s %-15s %-15s %-10s\n", fruit.getName(), fruit.getQuantity(),fruit.getPrice(), fruit.getAmount());
        }
        
        // Display the total amount of the invoice
        System.out.println(invoice.getTotalMoney()+"$");
        // Prompt the user to enter their name for the invoice
        String customer = utility.getString("Enter customer: ", "Invalid input", utility.REGEX_STRING);
        // Set the customer name for the invoice
        invoice.setCustomer(customer);
        // Add the completed invoice to the list of invoices
        invoiceList.add(invoice);
        
    }
    
    /**
    * Checks if a fruit with the specified ID exists in the list of fruits.
    * @param item The ID of the fruit to be checked.
    * @return True if a fruit with the specified ID exists, false otherwise.
    */
    public boolean checkIdExist(String item) {
        //flag to mark duplicate test results
        boolean flag = true;
        //check from first to last list id worker exist or not
        for (Fruit fruit : fruitList) {
            if (item.equalsIgnoreCase(fruit.getId())) {
                   // Return true if a matching ID is found
                return flag;
            }
        }
            // Return false if no matching ID is found

        return !flag;
        
    }
    
    /**
    * Retrieves a fruit from the list of fruits based on its ID.
    * @param item The ID of the fruit to retrieve.
    * @return The fruit object with the specified ID, or null if not found.
    */
    public Fruit getFruitById(String item) {
            // Iterate through the list of fruits to find the fruit with the specified ID
        for (Fruit fruit : fruitList) {
                    // Check if the ID of the current fruit matches the specified ID (case-insensitive)

            if (fruit.getId().equalsIgnoreCase(item)) {
                            // Return the fruit object if a matching ID is found

                return fruit;
            }
        }
    // Return null if no matching ID is found (default "not found" Fruit object)
    return null;
    }
    
    /**
    * Displays the details of fruits in an invoice.
    * @param invoice The invoice containing the list of fruits.
    */
    public void displayInvoiceOrder(Invoice invoice) {
            // Print the header for the invoice details table

        System.out.format("%-10s %-15s %-15s %-10s\n", "Product", "Quantity","Price", "Amount");
            // Iterate through each fruit in the invoice's list of fruits

        for (Fruit fruit : invoice.getListFruitOrder()) {
            System.out.format("%-10s %-15s %-15s %-10s\n", fruit.getName(), fruit.getQuantity(),fruit.getPrice(), fruit.getAmount());
        }
    }
    
    /**
    * Displays the details of all orders in the list of invoices.
    * Iterates through each invoice in the list and prints the customer's name and the details of their order.
    */

    public void displayViewOrder() {
            // Iterate through each invoice in the list of invoices

        for (Invoice invoice : invoiceList) {
                    // Print the customer's name for the current invoice

            System.out.println("Customer: " + invoice.getCustomer());
                    // Display the details of the order for the current invoice

            displayInvoiceOrder(invoice);
        }
    }


    
    
}
