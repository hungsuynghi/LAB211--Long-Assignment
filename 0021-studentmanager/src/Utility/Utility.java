package Utility;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Utility {
    
    public final String REGEX_STRING = "[a-zA-Z0-9]+";
    public final String REGEX_YESNO = "[yYnN]";
    public final String REGEX_NAME = "[a-zA-Z]+";
    public final String REGEX_UPDATE = "[uDdD]";
    Scanner scanner = new Scanner(System.in);
    
    public int getInteger(String message, String error, int min, int max){
        
        
        while (true) {
            try {
                System.out.print(message);
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
            } catch (Exception e) {
                System.err.println(error);
            }
        }
        
        
    }
    
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

}
