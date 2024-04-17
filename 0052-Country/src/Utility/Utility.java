/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Utility {
    Scanner scanner = new Scanner(System.in);


    public int getInteger(String message, String error, int min, int max){
        
        
        while (true) {        
            try {
                System.out.println(message);
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);
                if (input.isEmpty()) {
                    System.out.println("Nhap input");
                }else if (number < min || number > max) {
                    System.out.println("Nhap lai input");
                }else{
                    return number;
                }
            } catch (NumberFormatException e) {
                System.err.println("Error");
            }

        }
  
    }
    
    
    
    public float getFloat(String message, String error, float min, float max){
        
        
        while (true) {        
            try {
                System.out.println(message);
                String input = scanner.nextLine();
                float number = Float.parseFloat(input);
                if (input.isEmpty()) {
                    System.out.println("Nhap input");
                }else if (number < min || number > max) {
                    System.out.println("Nhap lai input");
                }else{
                    return number;
                }
            } catch (NumberFormatException e) {
                System.err.println("Error");
            }

        }
  
    }
    
    public String getString(String message,String error,String regex ){
        while (true) {       
            System.out.println(message);
            String input = scanner.nextLine();
            
            if (input.isEmpty()) {
                System.out.println("Input can not empty");
            }else if (input.matches(regex)) {
                return input;
                
            }else{
                System.out.println(error);
            }
        }
    }
}
