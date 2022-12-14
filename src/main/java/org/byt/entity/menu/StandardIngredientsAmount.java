package org.byt.entity.menu;

import lombok.Data;

@Data
public class StandardIngredientsAmount {
    private int number;
    private StandardPosition standardPosition;
    private Ingredient ingredient;
}
