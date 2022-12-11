package org.byt.entity.menu;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustomSandwich {
    private String type;

    private Ingredient ingredient;

    private List<CustomSandwich> customSandwichList = new ArrayList<>();


    public CustomSandwich(String type, Ingredient ingredient) {
        this.type = type;
        this.ingredient = ingredient;
        customSandwichList.add(this);
    }
    public void createCustomSandwich(){
        //TODO придумать как cделать сендвич
    }
}
