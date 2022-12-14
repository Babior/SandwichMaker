package org.byt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.byt.constants.OrderStatusEnum;
import org.byt.constants.PaymentMethodEnum;
import org.byt.constants.PaymentStatusEnum;
import org.byt.entity.menu.MenuPosition;
import org.byt.entity.user.Customer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Data
@AllArgsConstructor
public class Order {

    private UUID id = UUID.randomUUID();
    private OrderStatusEnum orderStatusEnum;
    private boolean isPaid;
    private LocalDateTime date;
    private String details;
    private int totalCost;
    private List<MenuPosition> menuPositions;
    private PickUpPoint pickUpPoint;

    private List<Payment> payments;

    @Getter //viewOrderList()
    private static List<Order> orders = new ArrayList<>();

    public Order(OrderStatusEnum orderStatusEnum, boolean isPaid, LocalDateTime date, String details, int totalCost, List<MenuPosition> menuPositions, PickUpPoint pickUpPoint) {
        this.orderStatusEnum = orderStatusEnum;
        this.isPaid = isPaid;
        this.date = date;
        this.details = details;
        this.totalCost = totalCost;
        this.menuPositions = menuPositions;
        this.pickUpPoint = pickUpPoint;
    }

    public void makeOrder(Customer customer, Payment payment) {
        if (payment.getPaymentMethod().equals(PaymentMethodEnum.CARD)) {
            if (payment.getPaymentStatus().equals(PaymentStatusEnum.REJECTED)) {
                //TODO: either exception or set order payment status to cash at pick up point?
            }
        }
        this.date = LocalDateTime.now();
        customer.getOrderList().put(this.id, this);
        orders.add(this);
    }

    public BigDecimal calculateTotalCost() {
        return menuPositions.stream().map(MenuPosition::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void cancelOrder() {
        this.orderStatusEnum = OrderStatusEnum.CANCELLED;
    }

    public void viewStatus() {

    }

    public void changeStatus(OrderStatusEnum orderStatusEnum) {
        this.orderStatusEnum = orderStatusEnum;
    }
}
