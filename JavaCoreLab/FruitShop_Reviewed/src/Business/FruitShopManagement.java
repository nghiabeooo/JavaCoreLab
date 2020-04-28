/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Entity.Fruit;
import Entity.Order;
import Entity.OrderItem;
import java.util.ArrayList;

/**
 *
 * @author Greychan
 */
public class FruitShopManagement {

    public ArrayList<Fruit> fl;
    private ArrayList<Order> ol;

    public FruitShopManagement() {
        this.fl = new ArrayList<>();
        this.ol = new ArrayList<>();
    }

    public boolean addFruit(Fruit f) {
        for (int i = 0; i < fl.size(); i++) {
            if (f.getFruitId().equalsIgnoreCase(fl.get(i).getFruitId())) {
                return false;
            }
        }
        fl.add(f);
        return true;
    }

    public ArrayList<Order> getOrderList() {
        return this.ol;
    }

    public void addOrder(Order ord) {
//        Order ord = new Order();
//        for (OrderItem ordItem : ordItems) {
//            ord.addOrderItem(ordItem);
//        }
//        ord.setCustName(custName);
        ol.add(ord);
    }
}
