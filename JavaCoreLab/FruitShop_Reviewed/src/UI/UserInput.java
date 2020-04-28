/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entity.Fruit;
import Entity.Order;
import Entity.OrderItem;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Greychan
 */
public class UserInput {

    Scanner sc = new Scanner(System.in);
    Display display = new Display();

    public void printOrder(ArrayList<OrderItem> ordItems) {
        double total = 0;
        System.out.printf("\n%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");

        for (OrderItem ordItem : ordItems) {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", ordItem.getFruitName(),
                    ordItem.getQuantity(), ordItem.getPrice(),
                    ordItem.getPrice() * ordItem.getQuantity());
            total += ordItem.getPrice() * ordItem.getQuantity();
        }
        System.out.println("\nTotal: " + total + "$\n");
    }

    public void printOrderList(ArrayList<Order> ol) {
        for (Order ord : ol) {
            System.out.println("\nCustomer: " + ord.getCustName());

            this.printOrder(ord.getOrdItems());
        }
    }

    public void printFruitList(ArrayList<Fruit> fl) {
        System.out.println("\n---Fruit List---\n");
        for (Fruit f : fl) {
            System.out.println(f.getFruitName());
        }
    }

    public void succeedOrNot(boolean done) {
        if (!done) {
            System.out.println("\n---ID Existed---\n");
        } else {
            System.out.println("\n---Successfully Added---\n");
        }
    }

    public int inputInRange(int a, int b, String question) {
        sc = sc.reset();
        while (true) {
            System.out.println(question);
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
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

    public OrderItem inputOrderItem(ArrayList<Fruit> fl) {
        display.displayFruitList(fl);
        int index = this.inputInRange(1, fl.size(), "Enter item you want to buy: ");
        Fruit f = this.getFruitByItem(index, fl);
        int buyAmount = this.inputInRange(1, f.getQuantity(), "Enter the amount you want to buy: ");
        fl.get(index - 1).setQuantity(f.getQuantity() - buyAmount);
        return (new OrderItem(f.getFruitId(), f.getFruitName(), buyAmount, f.getPrice()));
    }

    public Fruit getFruitByItem(int index, ArrayList<Fruit> fl) {
        int checkIndex = 1;
        for (Fruit fruit : fl) {
            //check shop have item or not 
            if (fruit.getQuantity() != 0) {
                checkIndex++;
            }
            if (checkIndex - 1 == index) {
                return fruit;
            }
        }
        return null;
    }

    public Fruit inputFruit() {
        String id = this.inputString("Id? :");
        String name = this.inputString("Name? :");
        Double price = this.inputDouble("Price? :");
        Integer quantity = this.inputInteger("Quantity? :");
        String origin = this.inputString("Origin? :");

        Fruit f = new Fruit(id, name, price, quantity, origin);

        return f;
    }

    public Integer inputInteger(String question) {
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

    public Double inputDouble(String question) {
        sc = sc.reset();
        while (true) {
            System.out.println(question);
            Double result = Double.parseDouble(sc.nextLine().trim());
            if (result.isNaN()) {
                System.err.println("Not a decimal number");
                System.out.println("Enter again: ");
            } else {
                return result;
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

    public boolean inputYN(String question) {
        while (true) {
            String result = inputString(question);
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Only Y or N");
            System.out.println("Enter again: ");
        }
    }

}
