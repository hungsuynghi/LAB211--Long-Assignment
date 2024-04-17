/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Internship;
import utility.Utility;
import view.ViewCandidate;


/**
 *
 * @author Admin
 */
public class ManageCandidate {
    Utility utility = new Utility();
    public ArrayList<Candidate> listCandidate = new ArrayList<>();
    
    
    public void addCandidate(Candidate candidate) {
        listCandidate.add(candidate);
    }


    public boolean checkDuplicate(ArrayList<Candidate> candidates,String id) {
        //flag to mark duplicate test results
        boolean flag = true;
        //check from first to last list id worker exist or not
        for (Candidate candidate : listCandidate) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                System.err.println("Duplicate id");
                return flag;
            }
        }
        return !flag;
    }
    

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
    * Creates an experience object for a candidate.
    * 
    * This method prompts the user to enter the year of experience and professional skill for the candidate.
    * It then creates an Experience object with the provided details and returns it.
    * 
    * @param candidate The candidate for whom the experience is being created.
    * @return The created Experience object.
    */
    public Experience createExperience(Candidate candidate) {
        int yearExperience = utility.getInteger("Enter year of experience: ", "invalid input", 0, 100);
        String professionalSkill = utility.getString("Enter professional skill: ", "invalid input", utility.REGEX_STRING);
        return new Experience(yearExperience, professionalSkill, candidate);
    }

    /**
    * Creates a fresher object for a candidate.
    * 
    * This method prompts the user to enter the graduation date and graduation rank for the fresher candidate.
    * It then creates a Fresher object with the provided details and returns it.
    * 
    * @param candidate The candidate for whom the fresher details are being created.
    * @return The created Fresher object.
    */
    public Fresher createFresher(Candidate candidate) {
        String graduationDate = utility.getString("Enter graduation date: ", "invalid input", utility.REGEX_STRING);
        String graduationRank = utility.getGraduationRank();
        return new Fresher(graduationDate, graduationRank, candidate);
        
    }

    /**
    * Creates an internship object for a candidate.
    * 
    * This method prompts the user to enter the major, semester, and university details for the internship candidate.
    * It then creates an Internship object with the provided details and returns it.
    * 
    * @param candidate The candidate for whom the internship details are being created.
    * @return The created Internship object.
    */
    public Internship createInternship(Candidate candidate) {
        String major = utility.getString("Enter major: ", "invalid input", utility.REGEX_STRING);
        String semester = utility.getString("Enter semester: ", "invalid input", utility.REGEX_STRING);
        String university = utility.getString("Enter university: ", "invalid input", utility.REGEX_STRING);
        return new Internship(major, semester, university, candidate);
    }



    /**
    * Displays details of all candidates in the provided list.
    * 
    * This method formats and prints the details of all candidates in the given list,
    * including their ID, first name, last name, birth date, address, phone, email, and candidate type.
    * 
    * @param listCandidate The list of candidates to be displayed.
    */
    public void displayCandidate(ArrayList<Candidate> listCandidate) {
        System.out.format("%-10s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "ID", "First Name", "Last Name", "Birth Date"
                , "Address","Phone", "Email","Type Candidate");
        for (Candidate candidate : listCandidate) {
            System.out.println(candidate);
        }
    }

    /**
    * Searches for candidates based on name and candidate type.
    * 
    * This method prompts the user to enter a name (first name or last name) to search for candidates,
    * and also prompts for the type of candidate to narrow down the search.
    * It then iterates through the list of candidates, filtering based on the entered criteria,
    * and displays the details of matching candidates.
    */
    public void searchCandidate() {
        ViewCandidate view = new ViewCandidate();
        view.displayListNameCandidate(listCandidate);
        String nameSearch = utility.getString("Enter andidate name (First name or Last name): ", "invalid input", utility.REGEX_STRING);
        int typeCandidate = utility.getInteger("Enter type of candidate: ", "invalid input", 0, 2);
        for (Candidate candidate : listCandidate) {
            if (candidate.getTypeCandidate() == typeCandidate 
                    && (candidate.getFirstName().toUpperCase().contains(nameSearch.toUpperCase())
                    || candidate.getLastName().toUpperCase().contains(nameSearch.toUpperCase()))) {
                System.out.println(candidate.toString());
            }
        }
    }
    
}
