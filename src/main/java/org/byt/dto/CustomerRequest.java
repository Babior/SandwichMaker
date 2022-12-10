package org.byt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.byt.entity.user.User;

@Data
public class CustomerRequest extends UserRequest {
    String phone;

    public CustomerRequest(String firstName, String lastName, String email, String password, String phone) {
        super(firstName, lastName, email, password);
        this.phone = phone;
    }
}
