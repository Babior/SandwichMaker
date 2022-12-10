package org.byt.entity.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.byt.dto.AssistantRequest;
import org.byt.dto.CustomerRequest;
import org.byt.dto.UserRequest;

import java.util.UUID;

@Data
@NoArgsConstructor
public abstract class User {

    private UUID id = UUID.randomUUID();
    private String firstName;
    private String lastName;
    private String email;

    //TODO: можем ли мы убрать что пароль должен быть уникальным?
    private String password;

    public User(UserRequest newUser) {
        this.firstName = newUser.getFirstName();
        this.lastName = newUser.getLastName();
        this.email = newUser.getEmail();
        this.password = newUser.getPassword();
    }

    public abstract void createAccount(UserRequest newUser);

    public abstract void editAccount(UserRequest newUser);
}
