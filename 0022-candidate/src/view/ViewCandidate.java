/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ManageCandidate;
import java.util.ArrayList;
import java.util.Calendar;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Internship;
import utility.Utility;

/**
 *
 * @author Admin
 */
public class ViewCandidate {
    Utility utility = new Utility();
    ManageCandidate manage = new ManageCandidate();
    
    /**
    * Creates a new candidate based on the specified type.
    * prompts user for candidate details and adds the candidate to the list.
    * @param type The type of candidate to create (0 for Experience, 1 for Fresher, 2 for Internship).
    */
    public void createCandidate(int type) {
        while (true) {            

                while (true) {   
                    // Prompt user to enter candidate details
                String id = utility.getString("Enter id: ", "Invalid input", utility.REGEX_STRING);
                String firstName = utility.getString("Enter first name: ", "invalid input", utility.REGEX_STRING);
                String lastName = utility.getString("Enter last name: ", "Invalid input", utility.REGEX_STRING);
                int birthDate = utility.getInteger("Enter birth date: ", "Invalid input", 1900, Calendar.getInstance().get(Calendar.YEAR));
                String address = utility.getString("Enter address: ", "Invalid input", utility.REGEX_STRING);
                String phone = utility.getPhoneNumber("Enter phone: ");
                String email = utility.getEmail("Enter email: ");


                  // Create a candidate object with the provided details
                Candidate candidate = new Candidate(id, firstName, lastName, birthDate, address, phone, email, type); 
                // Check for duplicate candidate ID
                if (!manage.checkDuplicate(manage.listCandidate,id)) {
                    switch(type){
                        case 0:
                            // For Experience candidates, create an Experience object and add to the list
                            Experience newExperience =  manage.createExperience(candidate);
                            manage.addCandidate(newExperience);
                            break;
                        case 1:
                            // For Fresher candidates, create a Fresher object and add to the list
                            Fresher newFresher = manage.createFresher(candidate);
                            manage.addCandidate(newFresher);
                            break;
                        case 2:
                            // For Internship candidates, create an Internship object and add to the list
                            Internship newInternship = manage.createInternship(candidate);
                            manage.addCandidate(newInternship);
                            break;    
                    }
                }
                   // Prompt user to continue adding candidates or not
                if (!manage.checkYesNo()) {                   
                    return;
                }
            }
              
        }
    }
    
    /**
    * Searches for candidates based on user input.
    * If the list of candidates is empty, it prints a message indicating an empty list.
    * Otherwise, it search operation to the ManageCandidate class.
    */
    public void searchCandidates(){
        if (manage.listCandidate.isEmpty()) {
            System.out.println("empty list");
        }else{
            manage.searchCandidate();
        }     
    }
    
    /**
    * Displays the names of candidates by their types.
    * @param candidates The list of candidates to display.
    */
    public void displayListNameCandidate(ArrayList<Candidate> candidates) {
     // Print section header for Experience candidates
        System.out.println("===========EXPERIENCE CANDIDATE============");
        // loop through the list of candidates
        for (Candidate candidate : candidates) {
            // Check if the candidate is an instance of Experience
            if (candidate instanceof Experience) {
                // Print the first name and last name of the Experience candidate
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        
        // Print section header for Fresher candidates
        System.out.println("===========FRESHER CANDIDATE============");
         // loop through the list of candidates
        for (Candidate candidate : candidates) {
            // Check if the candidate is an instance of fresher
            if (candidate instanceof Fresher) {
                // Print the first name and last name 
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        
        // Print section header for intern candidates
        System.out.println("===========INTERN CANDIDATE============");
        // loop through the list of candidates
        for (Candidate candidate : candidates) {
            // Check if the candidate is an instance of intern
            if (candidate instanceof Internship) {
                // Print the first name and last name 
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
    }
    
   
         
    /**
 * Displays the menu options for the Candidate Management System and prompts the user to choose an option.
 * @return The selected option chosen by the user.
 */
    public int Menu(){
        // Display menu options
        System.out.println("\nCANDIDATE MANAGEMENT SYSTEM\n" +
                           "1.	Experience\n" +
                           "2.	Fresher\n" +
                           "3.	Internship\n" +
                           "4.	Searching\n" +
                           "5.	Exit");
        // Prompt user to enter option
        int option = utility.getInteger("Enter option: ", "Invalid input", 1, 5);
        //return selected option
        return option;
    }



    

}
