package org.byt.entity;

import lombok.Data;
import lombok.Getter;
import org.byt.entity.menu.Menu;
import org.byt.exception.ObjectNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class PickUpPoint {

    private String address; //makes more sense to decompose to country, city, street, building number

    private Warehouse warehouse;

    private Menu menu;

    private Map<Long, Order> orders;

    @Getter
    private static List<PickUpPoint> pickUpPoints = new ArrayList<>();

    public PickUpPoint(String address, Warehouse warehouse, Menu menu, Map<Long, Order> orders) {
        this.address = address;
        this.warehouse = warehouse;
        this.menu = menu;
        this.orders = orders;
        pickUpPoints.add(this);
    }

    public String getAddress() {
        return address;
    }

    public static PickUpPoint getByAddress(String address) {

        return pickUpPoints.stream()
                .filter(p -> p.getAddress().equals(address))
                .findAny()
                .orElseThrow(() -> new ObjectNotFoundException(PickUpPoint.class.getName(), address));
    }

    public List<PickUpPoint> getMenuPositionList(){
        return pickUpPoints;
    }

    public boolean createPickUpPoint() {
        pickUpPoints.add(this);
        return true;
    }
}
