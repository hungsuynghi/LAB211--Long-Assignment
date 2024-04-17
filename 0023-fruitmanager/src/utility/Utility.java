/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.Scanner;

/**
 * The Utility class provides utility methods for handling user input, such as getting integers, doubles,
 * and strings from the console. It also includes REGEX patterns for validating input.
 */
public class Utility {
     // Regex patterns for validating input
    public final String REGEX_STRING = "[a-zA-Z0-9 ]+";
    public final String REGEX_YESNO = "[yYnN]";
    public final String REGEX_NAME = "[a-zA-Z ]+";
    public final String REGEX_UPDATE = "[uDdD]";
        // Scanner object for reading input from the console

    Scanner scanner = new Scanner(System.in);
    
    
    /**
     * Retrieves an integer input from the console within a specified range.
     * @param message The message prompt displayed to the user.
     * @param error The error message displayed if input is invalid.
     * @param min The minimum value allowed for the input.
     * @param max The maximum value allowed for the input.
     * @return The valid integer input from the user.
     */
    public int getInteger(String message, String error, int min, int max){
        while (true) {
            try {
                System.out.println(message);
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.err.println("Input cannot blank");
                } else {
                    int number = Integer.parseInt(input);
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.err.println("You must enter within range " + min + "-" + max);
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println(error);
            }
        }
    }
    
    /**
    * Retrieves a double input from the console within a specified range.
    * @param message The message prompt displayed to the user.
    * @param error The error message displayed if input is invalid.
    * @param min The minimum value allowed for the input.
    * @param max The maximum value allowed for the input.
    * @return The valid double input from the user.
    */
    public double getDouble(String message, String error, double min, double max) {
        
        while (true) {
            try {
                            // Display the message prompt to the user

                System.out.println(message);
                            // Read the input from the console

                String input = scanner.nextLine();
                            // Check if the input is empty

                if (input.isEmpty()) {
                                    // Display an error message if input is blank

                    System.err.println("Input cannot blank");
                } else {
                                    // Parse the input string to a double

                    double number = Double.parseDouble(input);
                                    // Check if the parsed number is within the specified range

                    if (number >= min && number <= max) {
                                            // Return the valid double input

                        return number;
                    } else {
                                            // Display an error message if the input is outside the range

                        System.err.println("You must enter within range " + min + "-" + max);
                    }
                }
            } catch (NumberFormatException e) {
                            // Display an error message if the input cannot be parsed to a double

                System.err.println(error);
            }
        }
    }
    
    /**
    * Retrieves a string input from the console that matches the specified regex pattern.
    * @param message The message prompt displayed to the user.
    * @param error The error message displayed if the input does not match the regex pattern.
    * @param regex The regular expression pattern used to validate the input.
    * @return The valid string input from the user.
    */
    public String getString(String message,String error,String regex ){
        while (true) {       
                    // Display the message prompt to the user

            System.out.println(message);
                    // Read the input from the console

            String input = scanner.nextLine();
                    // Check if the input matches the specified regex pattern

            if (input.matches(regex)) {
                            // Return the valid string input

                return input;
            }else{
                            // Display the error message if the input does not match the pattern

                System.out.println(error);
            }
        }
    }
}
