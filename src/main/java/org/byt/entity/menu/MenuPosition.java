package org.byt.entity.menu;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class MenuPosition {

    private String name;
    private BigDecimal price;
    private boolean isAvailable;
    private CustomSandwich customSandwich;
    private StandardPosition standardPosition;

    @Getter //viewMenuPositionList
    private static List<MenuPosition> menuPositionList = new ArrayList<>();

    public MenuPosition(String name, BigDecimal price, boolean isAvailable, CustomSandwich customSandwich, StandardPosition standardPosition) {
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
        this.customSandwich = customSandwich;
        this.standardPosition = standardPosition;
        menuPositionList.add(this);
    }

    public boolean getIsAvailable() {
        return this.isAvailable;
    }

    public List<MenuPosition> getMenuPositionList(){
        return menuPositionList;
    }

    public boolean createMenuPosition(){
        menuPositionList.add(this);
        return true;
    }

    public void blockPosition(){
        this.isAvailable = false;
    }

    public void unblockPosition(){
        this.isAvailable = true;
    }

}
