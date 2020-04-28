/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;

/**
 *
 * @author Greychan
 */
public class Order {

    private String custName;
    private ArrayList<OrderItem> ordItems;

    public Order() {
        this.ordItems = new ArrayList<>();
    }

    public Order(String custName) {
        this.custName = custName;
        this.ordItems = new ArrayList<>();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void addOrderItem(OrderItem ordItem) {
        if (this.ordItems == null) {
            this.ordItems.add(ordItem);
        }
        for (OrderItem oi : ordItems) {
            if (oi.getFruitId().equalsIgnoreCase(ordItem.getFruitId())) {
                oi.setQuantity(oi.getQuantity() + ordItem.getQuantity());
                return;
            }
        }
        this.ordItems.add(ordItem);
    }

    public ArrayList<OrderItem> getOrdItems() {
        return ordItems;
    }

    public double getTotal() {
        double total = 0;
        for (OrderItem ordItem : ordItems) {
            total += ordItem.getQuantity() * ordItem.getPrice();
        }
        return total;
    }
}
