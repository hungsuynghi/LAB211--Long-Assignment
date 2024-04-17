package Main;

import Controller.ManageStudent;
import Utility.Utility;
import View.ViewStudent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
      
      Utility utility = new Utility();  
      ViewStudent view = new ViewStudent();
      
      while (true) {   
            
             //display menu
            displayMenu();
            //enter the option
            int option = utility.getInteger("Enter the option:\n", "Enter the valid option", 1, 5);
           
            //display input option
            switch(option){
                case 1:
                    
                    view.inputStudent();
                    break;
                case 2:
                    view.findAndSortStudentByName();
                    break;
                case 3:
                    view.updateAndDelete();
                    break;
                case 4:
                    view.reportStudent();
                    break;
                case 5:
                    //exit
                    System.exit(0);
                    break;
            }

        } 
    }
    
    private static void displayMenu(){
        System.out.println("\nWELCOME TO STUDENT MANAGEMENT\n" +
                           "1. Create\n" +
                           "2. Find and Sort\n" +
                           "3. Update/Delete\n" +
                           "4. Report\n" +
                           "5. Exit\n");
    }
      

}
    
    
    
    
    

