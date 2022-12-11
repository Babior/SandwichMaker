package org.byt.entity.menu;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Ingredient {
    private String name;
    private String description;
    private int stock;
    private BigDecimal price;
    private boolean isAvailable;

    private static List<Ingredient> ingredients = new ArrayList<>();

    public Ingredient(String name, String description, int stock, BigDecimal price, boolean isAvailable) {
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.isAvailable = isAvailable;
        ingredients.add(this);
    }

    public void blockIngredient() {
        this.isAvailable = false;
    }

    public void unblockIngredient() {
        this.isAvailable = true;
    }
}
