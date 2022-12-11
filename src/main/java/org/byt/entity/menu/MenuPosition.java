package org.byt.entity.menu;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter //viewMenuPositionList
public class MenuPosition {

    private String name;
    private BigDecimal price;
    private boolean isAvailable;
    private CustomSandwich customSandwich;
    private StandardPosition standardPosition;

    private static List<MenuPosition> menuPositionList = new ArrayList<>();

    public MenuPosition(String name, BigDecimal price, boolean isAvailable, CustomSandwich customSandwich, StandardPosition standardPosition) {
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
        this.customSandwich = customSandwich;
        this.standardPosition = standardPosition;
        menuPositionList.add(this);
    }

    public static void blockPosition(){}

    public static void unblockPosition(){}

}
