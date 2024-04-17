/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import View.ViewCountry;
import Utility.Utility;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        ViewCountry view = new ViewCountry();
        Utility utility = new Utility();
        while (true) {   
            
             //display menu
            displayMenu();
            //enter the option
            int option = utility.getInteger("Enter the option: ", "Enter the valid option", 1, 5);
           
            //display input option
            switch(option){
                case 1:
                    view.inputCountry();
                    break;
                case 2:
                    view.displayCountryJustInput();
                    break;
                case 3:
                    view.searchCountryByName();
                    break;
                case 4:
                    view.sortCountriesByName();
                    break;
                case 5:
                    //exit
                    System.exit(0);
                    break;
            }
        } 
    }
    
    
    private static void displayMenu(){
        System.out.println("                MENU\n"
                +"======================================================================\n"
                +"1. Input the information of 11 countries in East Asia\n"
                +"2. Display the information of country you've just input\n"
                +"3. Search the information of country by user-entered name\n"
                +"4. Display the information of countries sorted name in ascending order\n"
                +"5. Exit\n "
                +"======================================================================\n");
    }
    
}
