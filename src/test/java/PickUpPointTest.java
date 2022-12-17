import org.byt.entity.PickUpPoint;
import org.byt.entity.Warehouse;
import org.byt.entity.menu.Menu;
import org.byt.entity.menu.MenuPosition;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PickUpPointTest {

    private static PickUpPoint pickUpPoint;
    private static List<PickUpPoint> pickUpPoints = new ArrayList<>();

    @BeforeClass
    public static void testSetup() {
        Warehouse warehouse = new Warehouse("Main", List.of());
        MenuPosition menuPosition = new MenuPosition("Sandwich", BigDecimal.valueOf(5), true, null, null);
        Menu menu = new Menu(List.of(menuPosition));
        pickUpPoint = new PickUpPoint("Koszykowa", warehouse, menu, new HashMap<>());
    }

    @Test
    public void testCreatePickUpPoint() {
        assertEquals(true, pickUpPoint.createPickUpPoint());
    }

    @Test
    public void testViewPickUpPointsList() {
        pickUpPoints.add(pickUpPoint);
        assertEquals(pickUpPoints, pickUpPoint.getMenuPositionList());
    }
}
