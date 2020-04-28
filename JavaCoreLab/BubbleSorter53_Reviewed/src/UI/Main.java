/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Business.Sorter;

/**
 *
 * @author Greychan
 */
public class Main {

    public static void main(String[] args) {
        int[] a = new int[0];
        Displayer dis = new Displayer();
        Validator val = new Validator();

        while (true) {
            System.out.println("1. Input Element");
            System.out.println("2. Sort Ascending");
            System.out.println("3. Sort Desceding");
            System.out.println("4. Exit.");
            int choice = val.inputInRange(1, 4, "Enter your choice: ");
            switch (choice) {
                case 1:
                    a = val.inputValueOfArray();
                    break;
                case 2:
                    a = Sorter.sortArrayAscending(a);
                    dis.printArray(a);
                    break;
                case 3:
                    a = Sorter.sortArrayDescending(a);
                    dis.printArray(a);
                    break;
                case 4:
                    return;
            }
        }
    }
}
