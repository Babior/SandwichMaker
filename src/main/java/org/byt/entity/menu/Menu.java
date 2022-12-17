package org.byt.entity.menu;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Menu {

    private UUID id = UUID.randomUUID();

    private List<MenuPosition> menuPositions;

    private static List<Menu> menus = new ArrayList<>();

    public Menu(List<MenuPosition> menuPositions) {
        this.menuPositions = menuPositions;
        menus.add(this);
    }

    public boolean createMenu() {
        menus.add(this);
        return true;
    }
}
