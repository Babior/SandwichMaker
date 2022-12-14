package org.byt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.byt.constants.PaymentMethodEnum;
import org.byt.constants.PaymentStatusEnum;
import org.byt.entity.user.Customer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Payment {

    private UUID id = UUID.randomUUID();
    private Customer customer;
    private Order order;
    private LocalDateTime paymentDate;
    private PaymentMethodEnum paymentMethod;
    private PaymentStatusEnum paymentStatus;

    @Getter
    private static List<Payment> payments;

    public Payment(Customer customer, Order order, PaymentMethodEnum paymentMethod, PaymentStatusEnum paymentStatus) {
        this.customer = customer;
        this.order = order;
        this.paymentDate = LocalDateTime.now();
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public void makePayment() {
        payments.add(this);
        this.order.setPaid(true);
    }

    public void sendConfirmation(Order o) {
        if (paymentStatus.equals(PaymentStatusEnum.CONFIRMED)) {
            //sendConfirmation to customer
        }
    }

    public void sendRejection(Order o) {
        if (paymentStatus.equals(PaymentStatusEnum.REJECTED)) {
            //sendRejection to customer
        }
    }

    public String sendPaymentInfo() {
        return "Your payment id: " + this.id + ", date " + this.paymentDate + ", chosen method: " + this.paymentMethod;
    }
}
