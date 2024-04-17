/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Utility {
    Scanner scanner = new Scanner(System.in);
    
    public final String REGEX_NAME = "[a-zA-Z ]+";
    public final String REGEX_STRING = "[a-zA-Z0-9 ]+";
    public final String REGEX_YESNO = "[yYnN]";
    
    
     /**
     * Retrieves an integer input from the user within a specified range.
     * @param message The message prompt displayed to the user.
     * @param error The error message displayed if the input is invalid.
     * @param min The minimum allowed value.
     * @param max The maximum allowed value.
     * @return The integer input provided by the user.
     */
    public int getInteger(String message, String error, int min, int max){
        while (true) {
            try {
                System.out.println(message);
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    throw new Exception("Input can not blank");
                } else {
                    int number = Integer.parseInt(input);
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        throw new Exception("You must enter within range " + min + "-" + max);
                    }
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
    
    
    /**
     * Retrieves a double input from the user.
     * @param message The message prompt displayed to the user.
     * @return The double input provided by the user.
     */
    public double getDouble(String message) {
        double input;
        while (true) {
            System.out.println(message);
            try {
                input = Double.parseDouble(scanner.nextLine());
                if (input < 0) {
                    throw new Exception("Invalid value, price must be positive number!");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }
    
    /**
    * Retrieves a string input from the user that matches a specified regular expression.
    * @param message The message prompt displayed to the user.
    * @param error The error message displayed if the input does not match the regular expression.
    * @param regex The regular expression pattern against which the input is validated.
    * @return The string input provided by the user.
    */
    public String getString(String message,String error,String regex ){
        while (true) {       
            System.out.println(message);            
            String input = scanner.nextLine();
            if (input.matches(regex)) {
                return input;
            }else{
                System.out.println(error);
            }
        }
    }
    

    /**
    * Retrieves a phone number input from the user.
    * @param message The message prompt displayed to the user.
    * @return The phone number input provided by the user.
    */
    public String getPhoneNumber(String message) {
        String input;
        while (true) {
            try {
                System.out.println(message);
                input = scanner.nextLine().toUpperCase();
                if (input.matches("^[\\d]{10,}$")) {
                    return input;
                }else {
                    throw new Exception(
                            "invalid phone number");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
    
    public String getEmail(String message) {
        String input;
        while (true) {
            try {
                System.out.println(message);
                input = scanner.nextLine();
                if (input.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$")) {
                    return input;
                }else {
                    throw new Exception(
                            "Invalid Email");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());                
            }
        }
    }
    
    
    /**
    * 
    * @param message The message prompt displayed to the user.
    * @return The email address input provided by the user.
    */
    public String getGraduationRank(){
        while (true) {            
            try {
                String input = getString("Enter graduation rank: ", "invalid input", REGEX_STRING);
                if (input.equalsIgnoreCase("Excellence")
                        || input.equalsIgnoreCase("Good")
                        || input.equalsIgnoreCase("Fair")
                        || input.equalsIgnoreCase("Poor")) {
                    return input;
                }else{
                    throw new Exception("input only accepts Excellence,Good,Fair,Poor");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
    

    
}
