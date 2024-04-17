/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linear.search;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        //declare array
        int sizeOfArray = Input.getInteger("Enter number of array: ", "Error", 1, Integer.MAX_VALUE);
        int[] array = new int[sizeOfArray];
        //enter random number
        LinearSearch.randomNumberRange(array);
        
        // enter search value

        int searchValue = Input.getInteger("Enter the search value", "Loi", 0, Integer.MAX_VALUE);
        
        //display array
        LinearSearch.displayArray(array,"Enter number of array:");
        //
        LinearSearch.displaySearchIndex(array, searchValue);
        
        
    }
}
