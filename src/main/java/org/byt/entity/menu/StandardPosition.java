package org.byt.entity.menu;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class StandardPosition {

    private Ingredient ingredient;

    private int kcal;

    private List<CustomIngredientsAmount> customIngredientsAmounts;

    private static List<StandardPosition> standardPositionList = new ArrayList<>();

    public StandardPosition(Ingredient ingredient, int kcal, List<CustomIngredientsAmount> customIngredientsAmounts){
        this.ingredient = ingredient;
        this.kcal = kcal;
        this.customIngredientsAmounts = customIngredientsAmounts;
        standardPositionList.add(this);
    }

    public boolean createStandardPosition() {
        standardPositionList.add(this);
        return true;
    }
}
