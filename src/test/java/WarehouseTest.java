import org.byt.entity.Warehouse;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

public class WarehouseTest {

    private static Warehouse warehouse1, warehouse2;

    @BeforeClass
    public static void testSetup() {

        warehouse1 = new Warehouse("Main", new HashMap<>());
        warehouse1 = new Warehouse("Secondary", new HashMap<>());
    }

    @AfterClass
    public static void testCleanup() {
        // Do your cleanup here like close URL connection , releasing resources etc
    }

    @Test
    public void testCreate() {
    }
}
