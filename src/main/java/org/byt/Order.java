package org.byt;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Order {
    private Integer number;
    private static int num = 0;
    private String details;
    private String[] statusArr = {"accepted", "cancelled", "in progress", "ready"};//discuss this part
    private String status;
    private boolean isPaid;
    private Date date;
    private int totalCost =calculateTotalCost();

    private static HashMap<Integer, Order> allOrders = new HashMap<>();


    public void makeOrder(Customer c, boolean isPaid) {
        number = ++num;
        date = Calendar.getInstance().getTime();
        this.isPaid = isPaid;

        c.getOrderList().put(number, this);//adding order, should be at the end
        allOrders.put(number, this);//adding order to general storage
    }
    public int calculateTotalCost(){//we need list of menu positions but have not done this yet
        return 0;
    }
    public void cancelOrder(Customer c){
        status = statusArr[1];
        c.getOrderList().remove(number);//probably can change just status of order
        //we do not need to delete order from general since order can get status cancelled
    }
    public String viewStatus(){
        return status;
    }
    public void changeStatus(String status){
        this.status = status;
    }

    public static HashMap<Integer, Order> getAllOrders() {
        return allOrders;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public static void viewOrderList(){
        allOrders.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
    }

}
