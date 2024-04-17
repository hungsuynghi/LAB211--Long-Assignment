/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Country;

/**
 *
 * @author Admin
 */
public class EastAsiaCountry extends Country{
    private String countryTerrain;

    public EastAsiaCountry() {
    }
    

    public EastAsiaCountry(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }
    
     public EastAsiaCountry(String countryCode, String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }


    @Override
    public void display() {
        super.display(); 
        System.out.format("%-10s\n", countryTerrain);
    }
    
    
    
    
    
    
}
