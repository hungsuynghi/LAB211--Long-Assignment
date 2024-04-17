/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;



import view.ViewFruit;

/**
 * The main entry point of the Fruit Shop System program.
 * Instantiates a ViewFruit object to interact with the user interface.
 * Displays the menu options in a loop and prompts the user for input.
 * Based on the user's selection, invokes the appropriate methods of the ViewFruit object.
 * The program continues running until the user chooses to exit.
 */
public class Main {
    public static void main(String[] args) {
                // Instantiate a ViewFruit object to interact with the user interface

        ViewFruit view = new ViewFruit();
                // Display the menu options in a loop and prompt the user for input

        while (true) {   
            
                    // Display the menu and get user input

            int option = view.Menu();

                        // Perform actions based on the user's selection

            switch(option){
                case 1: // Create a new fruit

                    view.createFruit();
                    break;
                case 2:
                    // shopping process
                    view.viewOrder();
                    break;
                case 3:
                    //shopping
                    view.shopping();
                    break;
                case 4:
                                        // Exit the program

                    System.exit(0);
                    break;
                
            }

        }
        
    }
    
}
