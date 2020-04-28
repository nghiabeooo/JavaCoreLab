/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Business.ManageEastAsiaCountry;
import Entity.EastAsiaCountry;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Greychan
 */
public class Main {

    public static void main(String[] args) throws Exception {
        InputHandler ih = new InputHandler();
        ManageEastAsiaCountry m = new ManageEastAsiaCountry();

        while (true) {
            ih.displayMenu();
            int choice = ih.inputIntInRange(1, 5, "Enter your choice: ");
            switch (choice) {
                case 1:
                    if (m.addCountryInformation(ih.inputCountry())) {
                        System.out.println("Successfully");
                        break;
                    } else {
                        System.out.println("Something went wrong");
                        break;
                    }
                case 2:
                    m.getRecentlyEnteredInformation().display();
                    break;
                case 3:
                    EastAsiaCountry[] l = m.searchInformationByName(ih.inputString("Enter the name you want to search for: "));
                    if (l == null) {
                        System.out.println("Not found");
                    } else {
                        ih.displayCountries(l);
                    }
                    break;
                case 4:
                    ih.displayCountries(m.sortInformationByAscendingOrder());
                    break;
                case 5:
                    return;
            }
        }
    }
}
