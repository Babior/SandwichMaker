package org.byt;

import java.util.ArrayList;

public abstract class User {
    private String name, surname, email, password;
    private int ID;

    private static int num = 0;//dlya auto-increment

    private ArrayList<String> passwordStorage = new ArrayList<>();

    public void createAccount(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;

        ID = ++num;

        if(!passwordStorage.contains(password)){
            this.password = password;
            passwordStorage.add(this.password);
        }
    }

    public void editAccount(String newName, String surname, String email, String password) {

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public int getID() {
        return ID;
    }

    public String getEmail() {
        return email;
    }


}
