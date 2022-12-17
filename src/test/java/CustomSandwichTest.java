import org.byt.entity.menu.CustomSandwich;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.assertEquals;

public class CustomSandwichTest {
    private static CustomSandwich customSandwich;

    @BeforeClass
    public static void testSetup() {
        customSandwich = new CustomSandwich("Vege", List.of(), List.of());
    }

    @Test
    public void testCreateCustomSandwich() {
        assertEquals(true, customSandwich.createCustomSandwich());
    }
}
