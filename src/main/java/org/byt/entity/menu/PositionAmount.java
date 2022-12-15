package org.byt.entity.menu;

import lombok.Data;
import org.byt.entity.Order;

@Data
public class PositionAmount {
    private int number;
    private MenuPosition menuPosition;
    private Order order;
}
