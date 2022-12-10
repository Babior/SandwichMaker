package org.byt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.byt.entity.menu.StandardPosition;
import org.byt.exception.ObjectNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Warehouse {

    private String name;

    private Map<Long, StandardPosition> standardPositions;

    @Getter
    private static List<Warehouse> warehouses = new ArrayList<>();


    public void update(List<StandardPosition> standardPositions) {
        //do update
    }

    public static Warehouse getByName(String name) {
        return warehouses.stream()
                .filter(p -> p.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new ObjectNotFoundException(Warehouse.class.getName(), name));
    }
}
