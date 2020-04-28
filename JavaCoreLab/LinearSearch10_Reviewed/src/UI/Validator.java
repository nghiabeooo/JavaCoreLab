/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Greychan
 */
public class Validator {

    Scanner sc = new Scanner(System.in);

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

    public int[] genIntArr() {
        int len = this.inputInteger("Enter number of array");
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = new Random().nextInt(len + 1);
        }
        return a;
    }

    public int inputIntInRange(int a, int b, String question) {
        sc = sc.reset();
        while (true) {
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
}
