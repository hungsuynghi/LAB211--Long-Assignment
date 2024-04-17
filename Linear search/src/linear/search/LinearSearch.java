/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linear.search;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Admin
 */
public class LinearSearch {
    
    static void randomNumberRange(int[] array){
        //generate random number
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(array.length);
        }
    }
    
    static void displayArray(int[] array, String message){
        System.out.println(message);
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print("[" + array[i] + " ,");
            }else if (i == array.length - 1) {
                System.out.print(array[i] + "]\n");
            }else {
                System.out.print(array[i] + " ,");
            }
        }
    }
    
    
    public static int searchIndex(int [] array, int searchValue){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchValue) {
                return i;
            }
            
        }
        return -1;
    }
    
    static void displaySearchIndex(int [] array, int searchValue){
       int indexSearch = searchIndex(array, searchValue);
        if (indexSearch == -1) {
            System.out.println("khong tim thay");
        }else {
            System.out.println("Found " +searchValue+" at index: "+ indexSearch );
        }
    }
}

