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
 * Represents a fresher candidate.
 * 
 * This class extends the Candidate class and adds attributes specific to fresher candidates,
 * such as graduation date and graduation rank.
 * It provides constructors, getter and setter methods for these attributes.
 */
public class Fresher extends Candidate{
    private String graduationDate;
    private String graduationRank;
    
    public Fresher() {
        super();
    }

    public Fresher(String graduationDate, String graduationRank, Candidate candidate) {
        super(candidate.getId(), candidate.getFirstName(), candidate.getLastName()
                ,candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), 
                candidate.getEmail(), candidate.getTypeCandidate());
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
    }


    public Fresher(String graduationDate, String graduationRank, String id,
            String firstName, String lastName, int birthDate, String address,
            String phone, String email, int typeCandidate) {
        super(id, firstName, lastName, birthDate, address, phone, email,
                typeCandidate);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
    }


    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }
}
