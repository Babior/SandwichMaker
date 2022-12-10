package org.byt;

import java.util.HashMap;

public class Customer extends User{

    private long phone;
    private HashMap<Integer, Order> orderList;//single customer can make infinite amount of orders

    public HashMap<Integer, Order> getOrderList() {
        return orderList;
    }

    public Customer(long phone){
        this.phone = phone;
    }

}
