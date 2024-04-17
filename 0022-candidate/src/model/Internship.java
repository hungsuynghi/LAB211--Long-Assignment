/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */


/**
 * Represents an internship candidate.
 * 
 * This class extends the Candidate class and adds attributes specific to internship candidates,
 * such as major, semester, and university.
 * It provides constructors, getter and setter methods for these attributes.
 */
public class Internship extends Candidate {

    private String major;
    private String semester;
    private String university;

    public Internship() {
        super();
    }

    public Internship(String major, String semester, String university, Candidate candidate) {
        super(candidate.getId(), candidate.getFirstName(), candidate.getLastName()
                ,candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), 
                candidate.getEmail(), candidate.getTypeCandidate());
        this.major = major;
        this.semester = semester;
        this.university = university;
    }
    

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}