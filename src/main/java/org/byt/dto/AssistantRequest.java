package org.byt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AssistantRequest extends UserRequest{
    String salary;
    String pickUpPointAddress;
    String warehouseName;

    public AssistantRequest(String firstName, String lastName, String email, String password, String salary, String pickUpPointAddress, String warehouseName) {
        super(firstName, lastName, email, password);
        this.salary = salary;
        this.pickUpPointAddress = pickUpPointAddress;
        this.warehouseName = warehouseName;
    }
}
