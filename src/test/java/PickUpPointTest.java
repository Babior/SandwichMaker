import org.byt.entity.PickUpPoint;
import org.byt.entity.Warehouse;
import org.byt.entity.menu.Menu;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

public class PickUpPointTest {

    private static PickUpPoint pickUpPoint;

    @BeforeClass
    public static void testSetup() {
        Warehouse warehouse = new Warehouse("Main", new HashMap<>());
        Menu menu = new Menu();
        pickUpPoint = new PickUpPoint("Koszykowa", warehouse, menu, new HashMap<>());
    }

    @AfterClass
    public static void testCleanup() {
        // Do your cleanup here like close URL connection , releasing resources etc
    }

    @Test
    public void testCreate() {
    }
}
