package org.byt.entity;

import lombok.Data;
import lombok.Getter;
import org.byt.constants.PaymentMethodEnum;
import org.byt.constants.PaymentStatusEnum;
import org.byt.entity.user.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Payment {

    private UUID id = UUID.randomUUID();
    private Customer customer;
    private Order order;
    private LocalDateTime paymentDate;
    private PaymentMethodEnum paymentMethod;
    private PaymentStatusEnum paymentStatus;

    @Getter
    private static List<Payment> payments = new ArrayList<>();

    public Payment(Customer customer, Order order, PaymentMethodEnum paymentMethod, PaymentStatusEnum paymentStatus) {
        this.customer = customer;
        this.order = order;
        this.paymentDate = LocalDateTime.now();
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public void makePayment() {
        payments.add(this);
        changePaymentStatus(PaymentStatusEnum.CONFIRMED);
        this.order.setDate(LocalDateTime.now());
        this.order.setPaid(true);
    }

    public void changePaymentStatus(PaymentStatusEnum status){
        this.paymentStatus = status;
    }

    public String sendConfirmation(Order o) {
        if (paymentStatus.equals(PaymentStatusEnum.CONFIRMED)) {
            return sendPaymentInfo() + " was confirmed";
        }
        //TODO: exception if paymentStatus is not confirmed
        return null;
    }

    public String sendRejection(Order o) {
        if (paymentStatus.equals(PaymentStatusEnum.REJECTED)) {
            return sendPaymentInfo() + " was rejected";
        }
        //TODO: exception if paymentStatus is not rejected
        return null;
    }

    public String sendPaymentInfo() {
        return "Your payment id: " + this.id + ", date " + this.paymentDate + ", chosen method: " + this.paymentMethod;
    }
}
