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

    public void createCustomSandwich() {
        customSandwichList.add(this);
    }
}
