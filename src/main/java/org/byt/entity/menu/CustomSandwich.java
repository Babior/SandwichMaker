package org.byt.entity.menu;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class CustomSandwich {

    private String type;
    private List<Ingredient> ingredients;
    private List<CustomIngredientsAmount> customIngredientsAmounts;

    private static List<CustomSandwich> customSandwichList = new ArrayList<>();

    public CustomSandwich(String type, List<Ingredient> ingredients, List<CustomIngredientsAmount> customIngredientsAmounts){
        this.type = type;
        this.ingredients = ingredients;
        this.customIngredientsAmounts = customIngredientsAmounts;
        customSandwichList.add(this);
    }
    public boolean createCustomSandwich() {
        customSandwichList.add(this);
        return true;
    }
}
