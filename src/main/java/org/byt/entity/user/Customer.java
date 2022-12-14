package org.byt.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.byt.dto.CustomerRequest;
import org.byt.dto.UserRequest;
import org.byt.entity.Order;
import org.byt.entity.Payment;

import java.util.*;

@Data
@AllArgsConstructor
public class Customer extends User {
    private String phone;

    private List<Payment> payments;
    private final Map<UUID, Order> orderList;
    @Getter
    public static List<Customer> customers = new ArrayList<>();

    public Customer(CustomerRequest newUser) {
        super(newUser);
        this.phone = newUser.getPhone();
        this.orderList = new HashMap<>();
        customers.add(this);
    }

    @Override
    public void createAccount(UserRequest newUser) {
        //validate fields
        new Customer((CustomerRequest) newUser);
    }

    @Override
    public void editAccount(UserRequest newUser) {
        //validate fields
        //set All properties from the request
    }
}
