package UI;

import Business.FruitShopManagement;
import Entity.Fruit;
import Entity.Order;
import Entity.OrderItem;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Greychan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserInput ui = new UserInput();
        FruitShopManagement mng = new FruitShopManagement();
        Display display = new Display();

        Fruit f1 = new Fruit("001", "Mango", 1, 100, "VN");
        Fruit f2 = new Fruit("002", "Grape", 2, 100, "VN");
        Fruit f3 = new Fruit("003", "Avocado", 3, 100, "VN");
        Fruit f4 = new Fruit("004", "Orange", 4, 100, "VN");
        Fruit f5 = new Fruit("005", "Apple", 5, 100, "VN");

        mng.fl.add(f1);
        mng.fl.add(f2);
        mng.fl.add(f3);
        mng.fl.add(f4);
        mng.fl.add(f5);

        while (true) {
            System.out.println("---FruitShop---");
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");
            int choice = ui.inputInRange(1, 4, "    Enter your choice: ");
            switch (choice) {

                case 1:
                    Fruit f11 = ui.inputFruit();
                    ui.succeedOrNot(mng.addFruit(f11));
                    boolean con;
                    while (con = ui.inputYN("Do you want to continue? (Y/N)")) {
                        Fruit f12 = ui.inputFruit();
                        ui.succeedOrNot(mng.addFruit(f11));
                    }
                    ui.printFruitList(mng.fl);
                    System.out.println("\n---Done---\n");
                    break;

                case 2:
                    ArrayList<Order> ol = mng.getOrderList();
                    if (ol.isEmpty()) {
                        System.out.println("Nothing to print!");
                        break;
                    }
                    ui.printOrderList(ol);
                    break;

                case 3:
                    Order ord = new Order();

                    ord.addOrderItem(ui.inputOrderItem(mng.fl));
                    while (!ui.inputYN("Do you want to order now?")) {
                        ord.addOrderItem(ui.inputOrderItem(mng.fl));
                    }
                    ui.printOrder(ord.getOrdItems());
                    ord.setCustName(ui.inputString("Input your name: "));
                    mng.addOrder(ord);
                    System.out.println("\n---Add succesful---\n");
                    break;
                case 4:
                    return;

            }
        }
    }
}
