package org.byt.entity.menu;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CustomIngredientsAmount {
    private int number;
    private List<MenuPosition> menuPositions;
    private List<Ingredient> ingredients;
}
