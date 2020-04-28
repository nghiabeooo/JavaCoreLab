/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.Scanner;

/**
 *
 * @author Greychan
 */
public class Validator {

    Scanner in = new Scanner(System.in);

    public int checkInputInt() {
        //Lặp đến khi người dùng nhập đúng
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number.");
                System.out.print("Enter again: ");
            }
        }
    }

    public int inputSizeOfArray() {
        System.out.println("Input Length Of Arrays");
        System.out.print("Enter number: ");
        //Lặp đến khi người dùng nhập đúng
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result <= 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number greater than zero.");
                System.out.print("Enter again: ");
            }
        }
    }

    public int[] inputValueOfArray() {
        int n = inputSizeOfArray();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + i + ": ");
            a[i] = checkInputInt();
        }
        return a;
    }

    public int inputInRange(int a, int b, String question) {
        in = in.reset();
        while (true) {
            System.out.println(question);
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < a || result > b) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("In " + a + " to " + b);
                System.out.println("Enter again: ");
            }
        }
    }

}
