/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Utility.Utility;
import controller.ManageWorker;
import java.util.ArrayList;
import model.HistorySalary;
import model.Worker;

/**
 * Prompts the user to input details of a new worker and adds the worker to the system.
 * The user is prompted to input a unique worker ID.
 * If the entered ID already exists in the system, the user is prompted again until a unique ID is provided.
 * After entering the ID, the user is prompted to input the worker's name, age, salary, and work location.
 * A new Worker object is created with the provided details.
 * The new worker is then added to the system using the 'addWorker()' method of the 'ManageWorker' class.
 * Finally, the updated list of workers is displayed using the 'displayWorkerList()' method.
 */
public class ViewWorker { 
    Worker worker = new Worker();
    ManageWorker manage = new ManageWorker();
    Utility utility = new Utility();

        
    public void inputWorker(){
         // Prompt the user to input a unique worker ID
        String id; 
        while (true) {
            id = utility.getString("Enter Code: ", "Invalid input", utility.REGEX_STRING);
            //check if id exist
            if (!manage.checkDuplicate(id)) {               
                break;
            }
        }
        // Prompt the user to input the worker's information
        String name = utility.getString("Enter Name: ", "Invalid input", utility.REGEX_NAME);
        
        int age = utility.getInteger("Enter Age: ", "Invalid input", 18, 50);
        
        int salary = utility.getInteger("Enter Salary: ", "Invalid input", 1, Integer.MAX_VALUE);
        
        String workLocation = utility.getString("Enter work location: ", "Invalid input", utility.REGEX_STRING);
        
        // Create a new worker object with the provided details
        Worker worker = new Worker(id, name, age, salary, workLocation);        
        //add worker data to the program 
        manage.addWorker(worker);    
        //display workerList
        displayWorkerList(manage.listWorker);
    }
    
    
    
    public void increaseSalary(){
            // Check if the list of workers is empty

        if (manage.listWorker.isEmpty()) {
                    // If the list is empty, display a message indicating so

            System.out.println("list is empty");
        }else{
            // If the list is not empty, proceed to increase salaries
        // Call the 'upSalary()' method in the 'ManageWorker' class to increase salaries
            manage.upSalary();            
        }
    }
    
    
    /**
    * Decreases the salary of all workers in the system.
    * If the list of workers is empty, it prints a message indicating so.
    * Otherwise, it calls the 'downSalary()' method in the 'ManageWorker' class to decrease salaries.
    */
    public void decreaseSalary(){
        if (manage.listWorker.isEmpty()) {
            System.out.println("list is empty");
        }else{
            // If the list is not empty, proceed to decrease salaries
        // Call the 'downSalary()' method in the 'ManageWorker' class to decrease salaries
            manage.downSalary();
        }
    }
    
    public void displayAndSort(){       
       if (manage.listWorker.isEmpty()) {
            System.out.println("list is empty");
        }else{
           manage.displayHistoryList(manage.listHistory);
       }
        
    }
    

    /**
    * Displays the history of salary changes sorted by worker ID.
    * If the list of workers is empty, it prints a message indicating so.
    * Otherwise, it calls the 'displayHistoryList()' method in the 'ManageWorker' class
    * to display the history of salary changes, sorted by worker ID.
    */
    public void displaySalary(){
        if (manage.listWorker.isEmpty()) {
            System.out.println("list is empty");
        }else{
            // If the list is not empty, proceed to display and sort the history of salary changes
        // Call the 'displayHistoryList()' method in the 'ManageWorker' class to display the history
        // of salary changes, sorted by worker ID
            displayHistoryList(manage.listHistory);
        }
    }
    
    /**
    * Displays the list of workers.
    * 
    * @param listWorker The ArrayList containing the list of workers.
    */
    public void displayWorkerList(ArrayList<Worker> listWorker) {
        System.out.format("%-10s %-15s %-10s %-10s %-10s\n", "ID", "Name","Age", "Salary", "workLocation");
        // loop through each fruit in the list
        for (Worker worker : listWorker) {  
            System.out.println(worker);
        }
    }
    
    
    /**
    * Displays the history of salary changes.
    * 
    * @param listHistory The ArrayList containing the history of salary changes.
    */
    public void displayHistoryList(ArrayList<HistorySalary> listHistory) {
        System.out.format("%-10s %-15s %-10s %-10s %-10s %-10s %-10s\n", "ID", "Name","Age", "Salary", "workLocation", "Status", "Date");
        // loop through each fruit in the list
        for (HistorySalary historySalary : listHistory) {
            System.out.println(historySalary);
        }
    }

    

    /**
     * Displays the menu for worker management options.
     * 
     * @return The selected option from the menu.
     */
    public int Menu() {
        
        System.out.println("\n======== Worker Management =========\n" +
"1.	Add Worker\n" +
"2.	Up salary\n" +
"3.	Down salary\n" +
"4.	Display Information salary\n" +
"5.	Exit\n");
        
 
        int option = utility.getInteger("Enter the option: ", "Enter the valid option", 1, 5);
           
        return option;
    }
}
