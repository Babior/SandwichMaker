package org.byt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.byt.entity.menu.Menu;
import org.byt.exception.ObjectNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class PickUpPoint {

    private String address; //makes more sense to decompose to country, city, street, building number

    private Warehouse warehouse;

    private Menu menu;

    private Map<Long, Order> orders;

    @Getter
    private static List<PickUpPoint> pickUpPoints = new ArrayList<>();

    public static PickUpPoint getByAddress(String address) {

        return pickUpPoints.stream()
                .filter(p -> p.getAddress().equals(address))
                .findAny()
                .orElseThrow(() -> new ObjectNotFoundException(PickUpPoint.class.getName(), address));
    }
}
