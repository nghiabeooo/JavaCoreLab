/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entity.Person;
import java.util.Scanner;

/**
 *
 * @author Greychan
 */
public class InputHandler {

    Scanner sc = new Scanner(System.in);
    
    public void displayPersonInfo(Person person){
        System.out.println("\nInformation of Person you have entered: ");
        System.out.printf("Name: %s\n", person.getName());
        System.out.printf("Address: %s\n", person.getAddress());
        System.out.printf("Salary: %.1f\n", person.getSalary());
    }

    public Person inputPersonInfo() {
        while (true) {
            String name = this.inputString("Name? ");
            String address = this.inputString("Address? ");
            String sSalary = this.inputString("Salary? ");
            double salary;
            try {
                salary = Double.parseDouble(sSalary);
                if (salary > 0) {
                    return new Person(name, address, salary);
                } else {
                    System.err.println("Enter again: ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhap salary chua hop le");
            }
            return null;
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
