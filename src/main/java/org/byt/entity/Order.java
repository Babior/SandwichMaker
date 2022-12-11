package org.byt.entity;

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

//TODO: constructor and makeOrder() method
@Data
public class Order {

    private UUID id = UUID.randomUUID();
    private OrderStatusEnum orderStatusEnum;
    private boolean isPaid;
    private LocalDateTime date;

    private String details;

    private int totalCost;

    private List<MenuPosition> menuPositions;

    @Getter //viewOrderList()
    private static Map<UUID, Order> orders = new HashMap<>();

    public Order(OrderStatusEnum orderStatusEnum, boolean isPaid, LocalDateTime date, String details, int totalCost, List<MenuPosition> menuPositions) {
        this.orderStatusEnum = orderStatusEnum;
        this.isPaid = isPaid;
        this.date = date;
        this.details = details;
        this.totalCost = totalCost;
        this.menuPositions = menuPositions;
    }

    public void makeOrder(Customer customer, Payment payment) {
        if (payment.getPaymentMethod().equals(PaymentMethodEnum.CARD)) {
            if (payment.getPaymentStatus().equals(PaymentStatusEnum.REJECTED)) {
                //TODO: either exception or set order payment status to cash at pick up point?
            }
        }
        this.date = LocalDateTime.now();
        customer.getOrderList().put(this.id, this);
        orders.put(this.id, this);
    }

    public BigDecimal calculateTotalCost() {
        return menuPositions.stream().map(MenuPosition::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void cancelOrder() {
        this.orderStatusEnum = OrderStatusEnum.CANCELLED;
    }
}
