package org.byt.entity.menu;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class StandardPosition {
    private int kcal;

    private Ingredient ingredient;

    private List<StandardPosition> standardPositionList = new ArrayList<>();

    public StandardPosition(Ingredient ingredient, int kcal){
        this.ingredient = ingredient;
        this.kcal = kcal;
        standardPositionList.add(this);
    }
}
