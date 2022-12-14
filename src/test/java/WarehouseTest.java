import org.byt.entity.Warehouse;
import org.byt.entity.menu.StandardPosition;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WarehouseTest {

    private static Warehouse warehouse1, warehouse2;

    @BeforeClass
    public static void testSetup() {

        warehouse1 = new Warehouse("Main", new ArrayList<>());
        warehouse1 = new Warehouse("Secondary", new ArrayList<>());
    }

    @Test
    public void testCreateWarehouse() {

    }

    @Test
    public void testUpdateWarehouse() {
        //StandardPosition standardPosition1 = new StandardPosition();
        //StandardPosition standardPosition2 = new StandardPosition();
        //warehouse1.update(List.of(standardPosition1, standardPosition2));
    }
}
