import org.byt.entity.menu.MenuPosition;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class MenuPositionTest {
    private static MenuPosition menuPosition1, menuPosition2, menuPosition3;
    private static List<MenuPosition> menuPositionList1 = new ArrayList<>();

    @BeforeClass
    public static void testSetup() {
        menuPosition1 = new MenuPosition("French fries", BigDecimal.valueOf(3), false, null, null );
        menuPosition2 = new MenuPosition("Sandwich", BigDecimal.valueOf(5), true, null, null );
        menuPosition3 = new MenuPosition("Vege Sandwich", BigDecimal.valueOf(4), true, null, null );
    }

    @Test
    public void testCreateMenuPosition() {
        assertEquals(true, menuPosition3.createMenuPosition());
    }

    @Test
    public void testBlockPosition() {
        menuPosition2.blockPosition();
        assertEquals(false, menuPosition2.getIsAvailable());
    }

    @Test
    public void testUnblockPosition() {
        menuPosition1.unblockPosition();
        assertEquals(true, menuPosition1.getIsAvailable());
    }

    @Test
    public void testViewMenuPositionsList() {
        menuPositionList1.add(menuPosition1);
        menuPositionList1.add(menuPosition2);
        menuPositionList1.add(menuPosition3);
        assertEquals(menuPositionList1, menuPosition1.getMenuPositionList());
    }
}
