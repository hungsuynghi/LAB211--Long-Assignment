/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ManageStudent;
import Model.Report;
import Model.Student;
import Utility.Utility;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ViewStudent {
    // Utility object for input handling
    Utility utility = new Utility();
     // ManageStudent object for accessing student-related functionalities
    ManageStudent manage = new ManageStudent();
    // ArrayList to store reports related to students
    ArrayList<Report> reportList = new ArrayList<>();
    
    /**
     * Takes user input to add a new student, displays the student information, and adds it to the program.
     */
    public void inputStudent(){
        // // Check if the studentList has reached its limit
        if (manage.studentList.size() >=10) {
            // Ask the user if they want to continue adding students
            if (!manage.checkYesNo()) {
                return;
            }
        }
        
        // Get user input
        String id = utility.getString("Enter id: ", "error", utility.REGEX_STRING);
        
        String name = utility.getString("Enter name: ", "error", utility.REGEX_STRING);
        
        int semester = utility.getInteger("Enter semester:\n", "error", 1, 20);
        
        int course = utility.getInteger("Enter course: \n1. Java\n2. .Net\n3. C/C++:", "error", 1, 20);
        
        
        // Check for duplicate ID
        if (manage.isDuplicate(id)) {
            System.out.println("Duplicate id");
            return;
        }
        
        
        //Initialize a Student object
        Student student = new Student(name, id, semester, course);
        
        
        //Display student information
        System.out.format("%-10s %-15s %-10s %-10s\n", "ID", "Name", "Semester", "Course");
        System.out.println(student);
        //dd student data to the program 
        
        manage.addStudent(student);    
    }
    
    /**
     * Finds and sorts students by name based on user input.
     */
    public void findAndSortStudentByName(){
         // Get user input for the name to search
        String name = utility.getString("Enter the name to search: ", "Error", utility.REGEX_NAME);
         // Check if not found
        ArrayList<Student> findList = manage.findStudentByName(name);
        //check if not found
        if (findList.isEmpty()) {
                System.out.println("not found");
                // Create a sorted list and display student information
        }else{
            manage.sortStudentsByName(findList);
            System.out.format("%-10s %-15s %-10s %-10s\n", "ID", "Name", "Semester", "Course");
            for (Student student : findList) {
                System.out.println(student);
            }
        }
    }
    
    
    /**
     * Updates or deletes a student based on user input.
     */
    public void updateAndDelete(){
        // Get user input for the ID to update or delete
        String id = utility.getString("Enter id: ", "Error", utility.REGEX_STRING);
         // Find students by ID
        ArrayList<Student> findList = manage.getStudentById(id);
        // Check if the list is empty
        if (findList.isEmpty()) {
            System.err.println("This list is empty!!");
        } else {
             // Prompt the user for update or delete
            if (manage.checkUpdateOrDelete()) {
                manage.update(findList);
            } else {
                manage.delete(findList);
            }
        }

    }
    /**
     * Generates and displays a report of the total number of courses taken by each student.
     */
    public void reportStudent() {
         // Clear the reportList
        reportList.clear();
        // loop through the studentList to create reports
        for (Student first : manage.studentList) {
            if (!manage.checkExistReport(first)) {
                int totalCourse = 0;
                 // Count the total number of courses for each student
                for (Student second : manage.studentList) {
                    if (first.getId().equalsIgnoreCase(second.getId())
                            && first.getCourse() == second.getCourse()) {
                        totalCourse++;
                    }
                }
                  // Create a Report object and add it to the reportList
                Report report = new Report(first.getId(), first.getName(), first.getCourse(), totalCourse);
                reportList.add(report);
            }
        }
        // Display the report
        System.out.format("%-15s %-10s %-10s\n", "Name", "Course", "TotalCourse");
        for (Report report : reportList) {
            System.out.println(report);
        }
    }
    
 
}
        
        
  
    

        









