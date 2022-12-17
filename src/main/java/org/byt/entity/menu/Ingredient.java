package org.byt.entity.menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

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

    private List<StandardIngredientsAmount> standardIngredientsAmounts;

    private List<CustomIngredientsAmount> customIngredientsAmounts;

    @Getter
    private static List<Ingredient> ingredients = new ArrayList<>();

    public Ingredient(String name, String description, int stock, BigDecimal price, boolean isAvailable,
                      List<StandardIngredientsAmount> standardIngredientsAmounts,
                      List<CustomIngredientsAmount> customIngredientsAmounts) {
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.isAvailable = isAvailable;
        this.standardIngredientsAmounts = standardIngredientsAmounts;
        this.customIngredientsAmounts = customIngredientsAmounts;
        ingredients.add(this);
    }
    public boolean getIsAvailable() {
        return this.isAvailable;
    }

    public void blockIngredient() {
        this.isAvailable = false;
    }

    public void unblockIngredient() {
        this.isAvailable = true;
    }
}
