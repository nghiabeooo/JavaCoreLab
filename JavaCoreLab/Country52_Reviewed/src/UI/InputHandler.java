/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entity.EastAsiaCountry;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Greychan
 */
public class InputHandler {

    Scanner sc = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending order");
        System.out.println("5. Exit");
    }

    public int inputIntInRange(int a, int b, String question) {
        sc = sc.reset();
        while (true) {
            System.out.println(question);
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < a || result > b) { // Nếu số nhập vào < 1 hoặc > 3 thì thông báo lỗi
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + a + ", " + b + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public int inputInteger(String question) {
        sc = sc.reset();
        while (true) {
            System.out.println(question);
            Integer result = Integer.parseInt(sc.nextLine().trim());
            if (result < 0) {
                System.err.println("Bigger or equal 0");
                System.out.println("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public double inputDouble(String question) {
        sc = sc.reset();
        while (true) {
            System.out.println(question);
            try {
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input double");
                System.out.print("Enter again: ");
            }
        }
    }

    public String inputString(String question) {
        sc = sc.reset();
        while (true) {
            System.out.println(question);
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.println("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public EastAsiaCountry inputCountry() {
        String countryCode = this.inputString("Enter code of country: ");
        String countryName = this.inputString("Enter name of country: ");
        double countryArea = this.inputDouble("Enter total area: ");
        String countryTerrain = this.inputString("Enter terrain of country: ");
        return (new EastAsiaCountry(countryTerrain, countryCode, countryName, countryArea));
    }

    public void displayCountries(EastAsiaCountry[] lc) {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
        for (EastAsiaCountry country : lc) {
            country.display();
        }
    }

}
