/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ManageFruit;
import model.Fruit;
import model.Invoice;
import utility.Utility;

/**
 * The ViewFruit class provides methods to interact with the fruit shop system from a user interface perspective.
 * It includes functionality to create fruit, view orders, and perform shopping operations.
 * Additionally, it contains a method to display the main menu and retrieve user options.
 */
public class ViewFruit {
    //utility object for input handling
    Utility utility = new Utility();
    //Manage fruit object for accesing fruit-related func
    ManageFruit manage = new ManageFruit();
    //Invoice object for managing invoices
    Invoice invoice = new Invoice();
    
     /**
     * Allows the user to create new fruit items and add them to the system.
     * Prompts the user to enter details such as ID, name, price, quantity, and origin for each fruit.
     * Checks for duplicate IDs and validates user input.
     */
    public void createFruit(){
        
        while (true) {            
            
        
                    // Prompt the user to enter the ID of the fruit
            String id;
            while (true) {            
                id = utility.getString("Enter id: ", "error", utility.REGEX_STRING);
                            // Check if the entered ID is a duplicate

                if (manage.checkDuplicate(id)) {
                    System.err.println("Duplicate id");
                    System.out.println("Enter again:");
                }
                            // Exit the loop if the ID is valid
                break;
            }

        // Prompt the user to enter the name of the fruit

            String name = utility.getString("Enter name: ", "error", utility.REGEX_STRING);

            double price = utility.getDouble("Enter price: ", "Invalid input", 0, Double.MAX_VALUE);

            int quantity = utility.getInteger("Enter quantity: ", "Invalid input", 1, Integer.MAX_VALUE);

            String origin = utility.getString("Enter origin: ", "error", utility.REGEX_STRING);


                    // Initialize a fruit object with the entered details

            Fruit fruit = new Fruit(id, name, price, quantity, origin);
        // Add the fruit to the list of fruits managed by the controller

            manage.addFruit(fruit);
        // Ask the user if they want to continue adding more fruits

            if (!manage.checkYesNo()) {
                
                            // Display the list of fruits added so far

             manage.displayListFruit(manage.fruitList);
             break;
            }

       }
        


        
    }
    
    
    /**
 * Allows the user to initiate the shopping process.
 * Checks if the list of available fruits is empty.
 * If the list is empty, displays a message indicating that the shop is out of stock.
 * Otherwise, calls the shoppingFruit() method to start the shopping process.
 */
    public void shopping() {
        if (manage.fruitList.isEmpty()) {
            System.out.println("shop ban het hang roi");
            
        }else{
            manage.shoppingFruit();
        }

    }
    
    /**
 * Displays the list of orders made by customers.
 * Checks if the list of invoices is empty.
 * If the list is empty, displays a message indicating that there are no orders.
 * Otherwise, calls the displayViewOrder() method to show the list of orders.
 */
    public void viewOrder(){
        if (manage.invoiceList.isEmpty()) {
            System.out.println("het me list rui haha");
        }else{
            manage.displayViewOrder();
        }
    }

    /** 
 * Displays the menu options for the fruit shop system.
 * Prompts the user to select an option from the menu.
 * Validates the user input to ensure it is within the range of available options.
 * Returns the selected option.
 */
    public int Menu(){
        System.out.println("\nFRUIT SHOP SYSTEM\n" +
                           "1. Create Fruit\n" +
                           "2. View orders\n" +
                           "3. Shopping (for buyer)\n" +
                           "4. Exit");
        
     // Prompt the user to enter an option and validate the input

        int option = utility.getInteger("Enter the option: ", "Enter the valid option", 1, 4);
           
        return option;
    }
    
    
}
