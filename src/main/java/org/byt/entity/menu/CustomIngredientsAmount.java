package org.byt.entity.menu;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomIngredientsAmount {
    private int number;
    private CustomSandwich customSandwich;
    private Ingredient ingredient;
}
