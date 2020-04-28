/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Greychan
 */
public class EastAsiaCountry extends Country implements Comparable<EastAsiaCountry> {

    private String countryTerrain;

    public EastAsiaCountry(String countryTerrain, String countryCode, String countryName, double countryArea) {
        super(countryCode, countryName, countryArea);
        this.countryTerrain = countryTerrain;
    }

    public EastAsiaCountry() {
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
        System.out.printf("%-10s%-25s%-20.1f%-25s\n", this.getCountryCode(), this.getCountryName(), this.getCountryArea(), this.getCountryTerrain()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(EastAsiaCountry o) {
        return this.getCountryName().compareTo(o.getCountryName()); //To change body of generated methods, choose Tools | Templates.
    }

}
