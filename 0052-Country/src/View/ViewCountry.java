/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ManageEastAsiaCountries;
import Model.EastAsiaCountry;
import Utility.Utility;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ViewCountry {
    ManageEastAsiaCountries manage = new ManageEastAsiaCountries();
    EastAsiaCountry eastAsiaCountry = new EastAsiaCountry();
    Utility utility = new Utility();
    public void inputCountry(){
        if (manage.countryList.size() >= 11) {
            System.out.println("Enough country!");
            return;
        }
        
        
        //require to input country information including code nam total area, terrain
        String countryCode;
        while (true) {            
            countryCode = utility.getString("Enter code: ", "Error", "[a-zA-Z0-9]+");
            if (manage.isDuplicateCode(countryCode)) {
                System.out.println("dup code");
            }else{
                break;
            }
        }
        
        
        String countryName;
        while (true) {            
            countryName = utility.getString("Enter name: ", "Error", "[a-zA-Z0-9]+");
            if (manage.isDuplicateName(countryName)) {
                System.out.println("dup name");
            }else{
                break;
            }
        }
        
        
        float totalArea = utility.getFloat("Enter area: ", "Error", 1, Float.MAX_VALUE);
        
        String countryTerrain = utility.getString("Enter terrain: ", "Error", "[a-zA-Z0-9]+");
        //tao doi tuong
        EastAsiaCountry country = new EastAsiaCountry(countryCode, countryName, totalArea, countryTerrain);
        //hien thi ra
        country.display();
        
        //add data into the program
        manage.addCountry(country);
    }

    
    public void displayCountryJustInput(){
        //get ve country just input <=> quoc gia nam o index cuoi cung
        //index cuoi cung
        int lastIndex = manage.countryList.size()-1;
        //get ra quoc gia dua tren index cuoi cung
        EastAsiaCountry country = manage.countryList.get(lastIndex);
        //display
        country.display();
    }
    
    public void searchCountryByName(){
        //input name
        String searchResult = utility.getString("Enter name: ", "Error", "[a-zA-Z0-9]+");
        //search country by name
        ArrayList<EastAsiaCountry> searchList = manage.searchByName(searchResult);
        //check if not found
        if (searchList.isEmpty()) {
            System.out.println("Not found");
        }else{
            //found
            for (EastAsiaCountry eastAsiaCountry : searchList) {
                eastAsiaCountry.display();
            }
        }
    }
    
    public void sortCountriesByName(){
        //sort
        ArrayList<EastAsiaCountry> sortList = new ArrayList<>();
        //them toan bo phan tu trong countryList => sortList
        sortList.addAll(manage.countryList);
        
        //sort trong sortList
        manage.sortCountries(sortList);
        //display sortlist
        for (EastAsiaCountry eastAsiaCountry : manage.countryList) {
            eastAsiaCountry.display();
        }
    }
    
}
