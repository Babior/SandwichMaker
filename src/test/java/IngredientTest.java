import org.byt.entity.menu.Ingredient;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private static Ingredient ingredient1, ingredient2, ingredient3;

    @BeforeClass
    public static void testSetup() {
        ingredient1 = new Ingredient("Bun","White bread", 50,BigDecimal.valueOf(1),true, List.of(), List.of());
        ingredient2 = new Ingredient("French Fries","Portion of potato", 50,BigDecimal.valueOf(2),false, List.of(), List.of());
        ingredient3 = new Ingredient("Meet","Spicy Chiken", 150,BigDecimal.valueOf(3),true, List.of(), List.of());
    }

    @Test
    public void testBlockIngredient() {
        ingredient1.blockIngredient();
        assertEquals(false, ingredient1.getIsAvailable());
    }

    @Test
    public void testUnblockIngredient() {
        ingredient2.unblockIngredient();
        assertEquals(true, ingredient2.getIsAvailable());
    }
}
