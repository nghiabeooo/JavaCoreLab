/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entity.Doctor;
import java.util.Scanner;

/**
 *
 * @author Greychan
 */
public class InputHandler {

    Scanner sc = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("1. Add doctor");
        System.out.println("2. Update doctor");
        System.out.println("3. Delete doctor");
        System.out.println("4. Search doctor");
        System.out.println("5. Exit");
    }

    public Doctor inputDoc() {
        while (true) {
            String code = this.inputString("Code? ");
            String name = this.inputString("Name? ");
            String specialization = this.inputString("Specialization? ");
            int availability = this.inputInteger("Availability? ");
            return (new Doctor(code, name, specialization, availability));
        }
    }

    public Doctor inputDocInfo(String code) {
        while (true) {
            String name = this.inputString("Name? ");
            String specialization = this.inputString("Specialization? ");
            int availability = this.inputInteger("Availability? ");
            return (new Doctor(code, name, specialization, availability));
        }
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

}
