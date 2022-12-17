import org.byt.entity.Warehouse;
import org.byt.entity.menu.MenuPosition;;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class WarehouseTest {

    private static Warehouse warehouse1, warehouse2;
    private static MenuPosition menuPosition1;

    @BeforeClass
    public static void testSetup() {
        menuPosition1 = new MenuPosition("French fries", BigDecimal.valueOf(3), false, null, null );
        warehouse1 = new Warehouse("Main", List.of());
        warehouse2 = new Warehouse("Secondary", List.of());
    }

    @Test
    public void testCreateWarehouse() {
        assertEquals(true, warehouse2.createWarehouse());
    }

    @Test
    public void testUpdateWarehouse() {
        warehouse1.update(List.of(menuPosition1));
    }
}
