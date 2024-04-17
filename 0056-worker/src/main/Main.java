/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import view.ViewWorker;

/**
 *
 * @author Admin
 */

/**
 * The Main class serves as the entry point of the program.
 */
public class Main {
    /**
     * The main method, where program execution begins.
     * 
     * @param args The command-line arguments passed to the program (not used in this application).
     */
    public static void main(String[] args) {
        // Create an instance of ViewWorker to access worker management functionality

        ViewWorker view = new ViewWorker();
        while (true) {   
            
            //display menu
            int option = view.Menu();

            //display input option
            switch(option){
                case 1:
                                        // Option 1: Add a new worker

                     view.inputWorker();
                    break;
                case 2:
                                        // Option 2: Increase worker salary

                    view.increaseSalary(); 
                    break;
                case 3:
                                        // Option 3: Decrease worker salary

                    view.decreaseSalary();
                    break;
                case 4:
                                        // Option 4: Display and sort salary history

                    view.displayAndSort();
                    break;
                case 5:
                    //exit
                    System.exit(0);
                    break;
            }

        }
    }
}
