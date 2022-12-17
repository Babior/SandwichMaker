import org.byt.entity.menu.Menu;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.assertEquals;

public class MenuTest {
    private static Menu menu1;

    @BeforeClass
    public static void testSetup() {
        menu1 = new Menu(List.of());
    }

    @Test
    public void testCreateMenu() {
        assertEquals(true, menu1.createMenu());
    }
}
