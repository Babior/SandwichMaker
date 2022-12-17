import org.byt.entity.menu.Ingredient;
import org.byt.entity.menu.StandardPosition;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class StandardPositionTest {
    private static Ingredient ingredient2;
    private static StandardPosition standardPosition;

    @BeforeClass
    public static void testSetup() {
        ingredient2 = new Ingredient("French Fries","Portion of potato", 50, BigDecimal.valueOf(2),false, List.of(), List.of());
        standardPosition = new StandardPosition(ingredient2, 230, List.of());
    }

    @Test
    public void testCreateStandardPosition() {
        assertEquals(true, standardPosition.createStandardPosition());
    }
}
