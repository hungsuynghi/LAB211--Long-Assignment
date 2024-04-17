/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linear.search;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Input {
    public static int getInteger(String message, String error, int min, int max){
       Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        while (true) {            
        try {
            String input = scanner.nextLine();
            int number = Integer.parseInt(input);
            if (number < min || number > max) {
                System.out.println("Input again");
            }else{
                return number;
            }
        } catch (Exception e) {
            System.err.println(error);
        }
    }
}
}