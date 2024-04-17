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
 * Represents a candidate with experience.
 * 
 * This class extends the Candidate class and adds attributes specific to candidates with experience,
 * such as years of experience and professional skills.
 * It provides constructors, getter and setter methods for these attributes.
 */
public class Experience extends Candidate{
    private int yearExperience;
    private String professionalSkill;

    public Experience() {
        super();
    }

    public Experience(int yearExperience, String professionalSkill, Candidate candidate) {
        super(candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(),
                candidate.getEmail(), candidate.getTypeCandidate());
        this.yearExperience = yearExperience;
        this.professionalSkill = professionalSkill;
    }

    

    public int getYearExperience() {
        return yearExperience;
    }

    public void setYearExperience(int yearExperience) {
        this.yearExperience = yearExperience;
    }

    public String getProfessionalSkill() {
        return professionalSkill;
    }

    public void setProfessionalSkill(String professionalSkill) {
        this.professionalSkill = professionalSkill;
    }
    
    
    
    

}
