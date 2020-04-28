/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Business.SearchHelper;

/**
 *
 * @author Greychan
 */
public class Main {

    public static void main(String[] args) {
        SearchHelper m = new SearchHelper();
        Validator val = new Validator();
        Displayer dis = new Displayer();

        while (true) {
            int[] a = val.genIntArr();
            int searchVal = val.inputInteger("Enter search value: ");
            dis.displayArray(a, "The array: ");
            int keyIndex = m.linSearch(a, searchVal);
            System.out.println("\nFound " + searchVal + " at index: " + keyIndex);

            String result = val.inputString("Continue?");
            if (result.equalsIgnoreCase("Y")) {
                continue;
            }
            if (result.equalsIgnoreCase("N")) {
                break;
            }
        }
    }
}
