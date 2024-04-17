 package Controller;


import Model.Report;
import Model.Student;
import Utility.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class ManageStudent {
    // ArrayList to store a list of Student objects
    public ArrayList<Student> studentList = new ArrayList<>();
    Utility utility = new Utility();
    Student student = new Student();
    ArrayList<Report> reportList = new ArrayList<>();
    
    /**
     * function to add new student to the studentList
     *
     * @param student The Student object to be added
     */
    public void addStudent(Student student){
        studentList.add(student);
    }
    
    
    /**
     * Checks if a student with the given ID already exists in the studentList
     *
     * @param id The ID to check for duplication
     * @return True if a duplicate is found, false otherwise
     */
    public boolean isDuplicate(String id) {
        //flag to mark duplicate test results
        boolean flag = false;
        //loop through the studentList to check for duplicates based on ID
        for (Student student : studentList) {
            if (student.getId().equalsIgnoreCase(id)) {
                //Set the flag to true if a duplicate is found
                flag = true;
                return flag;
            }
        }
        //Return false if no duplicate is found
        return flag ;
    }
    
    
    /**
     * Asks the user whether to continue (yes or no) and returns the user's choice
     * @return True if the user wants to continue, false otherwise.
     */
    public boolean checkYesNo(){
        //flag to mark duplicate test results
        boolean flag = false;
        //let user for input and validate using the utility getString method.
        String result = utility.getString("Do you want to continue? (y/n)", "Error", utility.REGEX_YESNO);
        //Check if the user's input is 'y' (case-insensitive)
        if (result.equalsIgnoreCase("y")) {
            flag = true;//Set the flag to true if the user wants to continue.
            return flag;//Return true to indicate the user's choice.
        }else{
            return flag;//// Return false if the user does not want to continue.
        }
    }
    
    
    /**
     * Finds students whose names contain letter (case-insensitive) and returns a list of matching students.
     * @param name to search for within student names.
     * @return An ArrayList of students whose names contain the specified name
     */
    public ArrayList<Student> findStudentByName(String name) {
        // Convert the search substring and student names to uppercase for case-insensitive comparison.
        name = name.toUpperCase();
        ArrayList<Student> foundList = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getName().toUpperCase().contains(name)) {
                foundList.add(student);  
            }
        }
        return foundList;
    }
    
    /**
     * Sorts a given ArrayList of Student objects by their names in a case-insensitive manner.
     * @param sortList The ArrayList of Student objects to be sorted by name. 
     */
    public void sortStudentsByName(ArrayList<Student> sortList){
        // Utilize the Collections.sort method to sort the list based on the provided Comparator.
        Collections.sort(studentList, new Comparator<Student>() {
            @Override 
            public int compare(Student o1, Student o2) {
                // Compare student names in a case-insensitive using compareToIgnoreCase.
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
    }
    
    
    /**
     * Finds students with a specific ID and returns a list of matching students.
     * @param id The ID to search for in the studentList.
     * @return An ArrayList of students with the specified ID.
     */
    public ArrayList<Student> getStudentById(String id) {
        // ArrayList to store found students with the specified ID.
        ArrayList<Student> foundList = new ArrayList<>();
        //loop through the studentList to find students with the specified ID.
        for (Student student : studentList) {
            // Check if the student's ID matches the specified ID in a case-insensitive manner.
            if (student.getId().equalsIgnoreCase(id)) {
                // Add the matching student to the foundList.
                foundList.add(student);
            }
        }
        return foundList;// Return the list of found students with the specified ID.
    }
    
    
    /**
     * Asks the user whether to update (U) or delete (D) a student and returns the user's choice.
     * @return True if the user wants to update, false if the user wants to delete.
     */
    public boolean checkUpdateOrDelete() {
        boolean flag = false;
        String result = utility.getString("Do you want to update(U) or delete(D) student?  ", "please enter the Id of student", utility.REGEX_UPDATE);
        // Check if the user's input is 'u'
        if (result.equalsIgnoreCase("u")) {
            flag = true;// Set the flag to true if the user wants to update.
            return flag;// Return true to indicate the user's choice to update.
        }else{
            return flag;// Return false if the user wants to delete.
        }
    }
    
    
    
    
    /**
     * Updates the information of a selected student based on user input.
     * 
     * @param listFound The list of students to choose from for updating.
     */
    public void update(ArrayList<Student> listFound) {
        // Display the list of found students
        displayListFoundById(listFound);
        // Get the user's choice of which student to update.
        int option = utility.getInteger("Enter no: ", "Error", 1, listFound.size());
        // get the selected student from the list.
        Student studentChoice = listFound.get(option - 1);
        //get information of selected student
        String idUpdate = studentChoice.getId();
        
        String nameUpdate = studentChoice.getName();
        
        int semesterUpdate = studentChoice.getSemester();
        
        int courseUpdate = studentChoice.getCourse();
        
        
        // Update the student's information
        // Check if user wants to update ID and prompt for a new ID if necessary.
        if (checkUpdate("id")) {
            idUpdate = utility.getString("Enter the ID: ", "Please enter the valid value", utility.REGEX_STRING);
        }
        // Check if user wants to update name and prompt for a new name if necessary
        if (checkUpdate("name")) {
            nameUpdate = utility.getString("Enter name: ", "Please enter the valid value", utility.REGEX_STRING);
        }
        // Check if user wants to update semester and prompt for a new semester if necessary
        if (checkUpdate("semester")) {
            semesterUpdate = utility.getInteger("Enter the semester: ", "please enter the valid value", 1, 10);
        }
        // Check if user wants to update course and prompt for a new course if necessary
        if (checkUpdate("course")) {
            courseUpdate = utility.getInteger("Enter the Course: \n1. Java \n2. .Net \n3.C/C++  ", "Plaese enter the valid value", 1, 3);
        }
        // Check if new update are the same with the old one
        if (checkNotUpdate(idUpdate,nameUpdate,semesterUpdate,courseUpdate, studentChoice)) {
            System.out.println("Not update");
        }else if (isDuplicate(idUpdate)) {
            System.out.println("duplicate");
        }else{
            // Update the student's information if no issues are encountered.
            studentChoice.setId(idUpdate);
            updateAllName(idUpdate,nameUpdate);
            studentChoice.setSemester(semesterUpdate);
            studentChoice.setCourse(courseUpdate);
            
        }
        
        
        
    }
    
    /**
     * Deletes a selected student from the list based on user input.
     * @param listFound The list of students to choose from for deletion.
     */
    public void delete(ArrayList<Student> listFound) {
        // Display the list of found students 
        displayListFoundById(listFound);
         // Get the user's choice of which student to delete.
        int option = utility.getInteger("Enter no: ", "Error", 1, listFound.size());
         // getthe selected student from the list.
        Student studentChoice = listFound.get(option - 1);
          // Remove the selected student from the studentList.
        studentList.remove(studentChoice);
        System.out.println("Delete successfully");
    }
    
    
    /**
     * Displays the details of a list of found students 
     * @param listFound The list of students to be displayed.
     */
    public void displayListFoundById(ArrayList<Student> listFound) {
        System.out.format("%-10s %-10s %-15s %-10s %-10s\n", "NO", "ID", "Name", "Semester", "Course");
        for (int i = 0; i < listFound.size(); i++) {
            System.out.format("%-10s %s\n", i + 1, listFound.get(i));

        }
    }
    
   /**
    * Checks whether the user wants to update a specific aspect of a student's information.
    *
    * @param message the student's information to be updated (e.g., ID, name, semester, course).
    * @return True if the user wants to update, false otherwise
    */

    private boolean checkUpdate(String message) {
        boolean flag = false;
         //let user for input regarding updating student's information.
        String result = utility.getString("Do you want to update " + message + "? (y/n): ",
                 "input yes or no", utility.REGEX_YESNO);
        // Check if the user's input is 'y' (case-insensitive).
        if (result.equalsIgnoreCase("y")) {
            flag = true;// Set the flag to true if the user wants to update.
            return flag;// Return true to indicate the user's choice to update.
        }else{
            return flag;// Return false if the user does not want to update.
        }
    }
    
    
    /**
     * 
     * @param idUpdate The updated student ID.
     * @param nameUpdate The updated student name   
     * @param semesterUpdate The updated student semester
     * @param courseUpdate The updated student course
     * @param studentChoice The original student with current information.
     * @return True if there is no need to update, false otherwise.
     */

    private boolean checkNotUpdate(String idUpdate, String nameUpdate, int semesterUpdate, int courseUpdate, Student studentChoice) {
        boolean flag = false;
        // Check if the provided updated values are the same as the current values of the student.
        if (idUpdate.equalsIgnoreCase(studentChoice.getId())&& nameUpdate.equalsIgnoreCase(studentChoice.getName())
                && semesterUpdate == studentChoice.getSemester() && courseUpdate == studentChoice.getCourse()) {
            flag = true;// Set the flag to true if there is no need to update
            return flag; // Return true to indicate no need for an update.
        }
        return flag;// Return false if there is a need to update.
    }
    
    /**
     * 
     * @param idUpdate The updated ID used to identify students.
     * @param nameUpdate The updated name to be set for matching students.
     */

    public void updateAllName(String idUpdate, String nameUpdate) {
        for (Student student : studentList) {
            // Check if the current student's ID matches the provided updated ID.
            if (student.getId().equalsIgnoreCase(idUpdate)) {
                // Set the updated name for the matching student.
                student.setName(nameUpdate);
            }
        } 
    }
    
    /**
     * Checks if a report already exists for a given student and course combination.
     * @param first The student for whom the existence of a report is checked.
     * @return True if a report exists, false otherwise.
     */

    public boolean checkExistReport(Student first) {
        boolean flag = false;
         // loopthrough the reportList to check for an existing report.
        for (Report report : reportList) {
            // Check if the current report's ID and course match the provided student's ID and course.
            if (report.getId().equalsIgnoreCase(first.getId()) 
                    && report.getCourse() == first.getCourse()) {
                flag = true;// Set the flag to true if a report exists.
                return flag;// Return true to indicate the existence of a report.
            }
        }
        return flag;// Return true to indicate the existence of a report.
    }

    
    
}
