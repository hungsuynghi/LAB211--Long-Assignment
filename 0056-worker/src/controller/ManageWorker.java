/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Utility.Utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import model.HistorySalary;
import model.Worker;
import view.ViewWorker;

/**
 *
 * @author Admin
 */
public class ManageWorker {
        // ArrayList to store the list of workers

    public ArrayList<Worker> listWorker = new ArrayList<>();
    public ArrayList<HistorySalary> listHistory = new ArrayList<>();
        // Worker object for handling worker-related operations

    Utility utility = new Utility();
    Worker worker = new Worker();

    /**
     * function to add new student to the studentList
     *
     * @param worker The Student object to be added
     * 
     */
    public void addWorker(Worker worker){
        listWorker.add(worker);
    }
    

    /**
    * Checks if a worker ID already exists in the list of workers.
    * 
    * @param id The ID to check for duplication.
    * @return True if the ID is duplicated, false otherwise.
    */
    public boolean checkDuplicate(String id) {
        //flag to mark duplicate test results
        boolean flag = true;
        //check from first to last list id worker exist or not
        for (Worker worker : listWorker) {
            if (worker.getId().equalsIgnoreCase(id)) {
                System.err.println("Code(id) cannot be duplicated with existed Code in DB!");          
                return flag;               
            }
        }
        return !flag; // If no worker with the same ID is found, return false
    }

    
    /**
    * Retrieves a worker object based on the provided ID.
    * 
    * @param id The ID of the worker to retrieve.
    * @return The worker object if found, or null if not found.
    */
    public Worker getWorkerByCode(String id) {  
        //loop through the workerList to find worker with id
        for (Worker worker : listWorker) {
                    // If a worker with the same ID (case-insensitive) is found, return it

            if (worker.getId().equalsIgnoreCase(id)) {
                return worker;
            }
        }
            // If no worker with the specified ID is found, return null

        return null;
    }
    
    
 
    /**
 * Gets the current date in the format "dd/MM/yyyy".
 * 
 * @return The current date as a formatted string.
 */
    private String getCurrentUpdate() {
            // Create a date formatter with the desired format

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            // Get the current date and time from the system

        Calendar calendar = Calendar.getInstance();
            // Format the current date and time using the date formatter

        return dateFormat.format(calendar.getTime());
    }

  
    /**
     * Increases the salary of a selected worker and adds the salary increase to the salary history.
     */
    public void upSalary() {


        // Define a variable to store the selected worker whose salary will be updated

        Worker workChoice;
            // Prompt the user to enter the code of the worker whose salary is to be increased

        while (true) {            
            String id = utility.getString("Enter code: ", "Invalid input", utility.REGEX_STRING);
            
            workChoice = getWorkerByCode(id);
                    // Check if the entered ID is valid

            if (!checkIdExist(id)) {
                System.out.println("invalid input");
            }else{
                break;
            }
        }
                // Check if the entered update amount is valid (must be greater than the current salary)

       // Get the current salary of the selected worker

        int currentSalary = workChoice.getSalary();
   
        int updateSalary;
            // Prompt the user to enter the amount by which to increase the salary

        while (true) {    
            updateSalary = utility.getInteger("Enter update amount: ", "invalid input", 1, Integer.MAX_VALUE);
                    // Check if the entered update amount is valid (must be greater than the current salary)

            if (currentSalary >= updateSalary) {
                System.err.println("salary update must higher than current");
            }else{
                break;
            }
        }
            // Set the updated salary for the selected worker

        worker.setSalary(updateSalary);
            // Add the salary increase to the salary history

        listHistory.add(new HistorySalary("UP", getCurrentUpdate(), workChoice.getId(),
                workChoice.getName(), workChoice.getAge(), updateSalary, workChoice.getWorkLocation()));
  
    }
    
    /**
    * Decreases the salary of a selected worker and adds the salary decrease to the salary history.
    */
    public void downSalary() {
            // Define a variable to store the selected worker whose salary will be decreased

        Worker workChoice;
            // Loop to prompt the user for a valid worker code

        while (true) {            
                    // Prompt the user to enter a worker code

            String id = utility.getString("Enter code: ", "Invalid input", utility.REGEX_STRING);
                    // Retrieve the worker object corresponding to the entered code

            workChoice = getWorkerByCode(id);
                    // Check if the entered code is valid (i.e., worker with the given code exists)

            if (!checkIdExist(id)) {
                System.out.println("invalid input");
            }else{
                break;
            }
        }
            // Get the current salary of the selected worker

        int currentSalary = workChoice.getSalary();
   
        int updateSalary;
            // Loop to prompt the user for the updated salary amount

        while (true) {   
                    // Prompt the user to enter the updated salary amount

            updateSalary = utility.getInteger("Enter update amount: ", "invalid input", 1, Integer.MAX_VALUE);
                    // Check if the entered update amount is valid (must be lower than the current salary)

            if (currentSalary <= updateSalary) {
                System.err.println("salary update must lower than current");
            }else{
                break;
            }
        }
            // Set the updated salary for the selected worker

        worker.setSalary(updateSalary);
            // Add the salary decrease to the salary history

        listHistory.add(new HistorySalary("DOWN", getCurrentUpdate(), workChoice.getId(),
                workChoice.getName(), workChoice.getAge(), updateSalary, workChoice.getWorkLocation()));
  
    }


    /**
    * Checks if a worker ID exists in the list of workers.
    * 
    * @param id The ID to check for existence.
    * @return True if the ID exists, false otherwise.
    */
    public boolean checkIdExist(String id) {
        //flag to mark duplicate test results
        boolean flag = true;
        //check from first to last list id worker exist or not
        for (Worker worker : listWorker) {
            if (worker.getId().equalsIgnoreCase(id)) {
                return flag;
            }
        }
            // Return false if no matching ID is found
        return !flag;
        
    }

    /**
    * Displays the history of salary changes, sorted by worker ID.
    * 
    * @param listHistory The list of salary history records to display.
    */
    public void displayHistoryList(ArrayList<HistorySalary> listHistory) {
            // Display the headers for the salary history table

        System.out.format("%-10s %-15s %-10s %-10s %-10s %-10s %-10s\n", "ID", "Name","Age", "Salary", "workLocation", "Status", "Date");
        // loop through each fruit in the list
        for (HistorySalary historySalary : listHistory) {
                    // Display the details of each history record

            System.out.println(historySalary);
        }
            // Sort the list of history records by worker ID in a case-insensitive manner

        Collections.sort(listHistory, new Comparator<HistorySalary>() {
            @Override 
            public int compare(HistorySalary o1, HistorySalary o2) {
                // Compare worker id in a case-insensitive using compareToIgnoreCase.
                return o1.getId().compareToIgnoreCase(o2.getId());
            }
        });
        
        
        
    }

}
