/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import view.ViewCandidate;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        ViewCandidate view = new ViewCandidate();
        
        while (true) {    
            
            int option = view.Menu();
            switch(option){
                case 1:
                    view.createCandidate(0);
                    break;
                case 2:
                    view.createCandidate(1);
                    break;
                case 3:
                    view.createCandidate(2);
                    break;
                case 4:
                    view.searchCandidates();
                    break;
                case 5:
                    System.exit(0);
                    break;    
            }
        }
    }   
}
