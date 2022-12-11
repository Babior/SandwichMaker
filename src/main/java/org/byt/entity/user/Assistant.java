package org.byt.entity.user;

import lombok.Data;
import lombok.Getter;
import org.byt.dto.AssistantRequest;
import org.byt.dto.CustomerRequest;
import org.byt.dto.UserRequest;
import org.byt.entity.Order;
import org.byt.entity.PickUpPoint;
import org.byt.entity.Warehouse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class Assistant extends User {

    private PickUpPoint pickUpPoint;

    private Warehouse warehouse;
    private BigDecimal salary;
    @Getter
    private static List<Assistant> assistants = new ArrayList<>();

    public Assistant(AssistantRequest newUser) {
        super(newUser);
        this.salary = new BigDecimal(newUser.getSalary());
        this.pickUpPoint = PickUpPoint.getByAddress(newUser.getPickUpPointAddress());
        this.warehouse = Warehouse.getByName(newUser.getWarehouseName());
        assistants.add(this);
    }

    //TODO: на основании чего у нас считается зарплата? или после чего пересчитывается?
    public int calculateSalary() {
        return 0;
    }

    @Override
    public void createAccount(UserRequest newUser) {
        //validate fields
        new Assistant((AssistantRequest) newUser);
    }

    @Override
    public void editAccount(UserRequest newUser) {
        //validate fields
        //set All properties from the request
    }
}
