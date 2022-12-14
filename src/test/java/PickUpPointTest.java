import org.byt.entity.PickUpPoint;
import org.byt.entity.Warehouse;
import org.byt.entity.menu.Menu;
import org.byt.entity.menu.MenuPosition;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PickUpPointTest {

    private static PickUpPoint pickUpPoint;

    @BeforeClass
    public static void testSetup() {
        Warehouse warehouse = new Warehouse("Main", new ArrayList<>());
        MenuPosition menuPosition = new MenuPosition("Sandwich", new BigDecimal(100), true, null,null);//add random values
        Menu menu = new Menu(List.of(menuPosition));
        pickUpPoint = new PickUpPoint("Koszykowa", warehouse, menu, new HashMap<>());
    }

    @Test
    public void testCreatePickUpPoint() {

    }

    @Test
    public void testViewPickUpPointsList() {
        //PickUpPoint.getPickUpPoints();
    }
}
