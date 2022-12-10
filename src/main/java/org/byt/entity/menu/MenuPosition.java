package org.byt.entity.menu;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MenuPosition {

    private String name;
    private BigDecimal price;
    private boolean isAvailable;

}
