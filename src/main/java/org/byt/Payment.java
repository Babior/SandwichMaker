package org.byt;

import java.util.Date;


public class Payment {
    private Customer cust;
    private Order order;
    private int num;
    private static int n = 0;
    private Date paymentDate;
    private String method;
    private String[] paymentStatus = null;//maybe we can use class Optional..disscuss this part

    public Payment(Customer c, Order o){
        cust = c;
        order = o;
    }

    public Order getOrder() {
        return order;
    }

    public void makePayment(){
        num = ++n;
        getOrder().setPaid(true);
    }
    public void sendConfirmation(Order o){
        if(o.isPaid()) {//could be removed actually.
            // depending on payment status we will send confirmation or rejection
            }
    }
    public void sendRejection(Order o){

    }
    public String sendPaymentInfo(){
        return "Your payment id: " + num + ", date " + paymentDate + ", chosen method: " + method;
    }

}
