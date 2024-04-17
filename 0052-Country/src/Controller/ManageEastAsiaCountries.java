/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.EastAsiaCountry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


/**
 *
 * @author Admin
 */


public class ManageEastAsiaCountries {
    public ArrayList<EastAsiaCountry> countryList = new ArrayList<>();
    
    // Method to add a country to the list
    public void addCountry(EastAsiaCountry country){
        countryList.add(country);
    }
    

    /**
     * Checks whether a country with the provided country code already exists in the country list
     * @param countryCode The country code to be checked for duplication.
     * @return True if a country with the given code already exists, false otherwise.
     */
    public boolean isDuplicateCode(String countryCode) {
        for (EastAsiaCountry eastAsiaCountry : countryList) {
            if (eastAsiaCountry.getCountryCode().equalsIgnoreCase(countryCode)) {
                return true;
            }
        }
        return false;
    }

    public boolean isDuplicateName(String countryName) {
        for (EastAsiaCountry eastAsiaCountry : countryList) {
            if (eastAsiaCountry.getCountryName().equalsIgnoreCase(countryName)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 
     * @param countryName The name to be used for searching countries
     * @return An ArrayList containing EastAsianCountry objects that match the given name (case-insensitive)
     */
    public ArrayList<EastAsiaCountry> searchByName(String countryName){
        ArrayList<EastAsiaCountry> searchList = new ArrayList<>();
        //loop for each element in countrylist
        for (EastAsiaCountry eastAsiaCountry : countryList) {
            //check element's name contain name, ignore case
            if (eastAsiaCountry.getCountryName().equalsIgnoreCase(countryName)) {
                searchList.add(eastAsiaCountry);
            }
        }
        return searchList;
    }
    
    public void sortCountries(ArrayList<EastAsiaCountry> sortList){
        Collections.sort(sortList, new Comparator<EastAsiaCountry>(){
            @Override
            public int compare(EastAsiaCountry o1, EastAsiaCountry o2) {
                //sap xep theo ten
                return o1.getCountryName().compareToIgnoreCase(o2.getCountryName());
            }
        });    
    }
}
 