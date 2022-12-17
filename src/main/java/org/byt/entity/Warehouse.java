package org.byt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.byt.entity.menu.MenuPosition;
import org.byt.exception.ObjectNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Warehouse {

    private String name;

    private List<MenuPosition> menuPosition;

    @Getter
    private static List<Warehouse> warehouses = new ArrayList<>();

    public Warehouse(String name, List<MenuPosition> menuPosition) {
        this.name = name;
        this.menuPosition = menuPosition;
        warehouses.add(this);
    }

    public String getName() {
        return name;
    }

    public static Warehouse getByName(String name) {
        return warehouses.stream()
                .filter(p -> p.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new ObjectNotFoundException(Warehouse.class.getName(), name));
    }

    public boolean createWarehouse() {
        warehouses.add(this);
        return true;
    }

    public void update(List<MenuPosition> menuPosition) {
        this.menuPosition = new ArrayList<>(menuPosition);;
    }

}
