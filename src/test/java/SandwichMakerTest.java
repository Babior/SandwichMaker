import static org.junit.Assert.assertEquals;

import org.byt.constants.OrderStatusEnum;
import org.byt.constants.PaymentMethodEnum;
import org.byt.constants.PaymentStatusEnum;
import org.byt.dto.CustomerRequest;
import org.byt.dto.UserRequest;
import org.byt.entity.Order;
import org.byt.entity.Payment;
import org.byt.entity.PickUpPoint;
import org.byt.entity.Warehouse;
import org.byt.entity.menu.*;
import org.byt.entity.user.Customer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SandwichMakerTest {

    private static UserRequest customerR;
    private static List<MenuPosition> menuPositions = new ArrayList<>();
    private static PickUpPoint pickUpPoint1;
    private static Order order1, order2;
    private static Customer customer;
    private static Payment payment1, payment2;
    private static Menu menu;
    private static Warehouse warehouse;
    private static CustomSandwich customSandwich;
    private static Ingredient ingredient1, ingredient2, ingredient3;
    private static Ingredient ingredient4;
    private static StandardPosition standardPosition1;

    @BeforeClass
    public static void testSetup() {
        customerR = new CustomerRequest("Anastasiya", "Sukach", "anastasiya.sukach@gmail.com",
                "password", "+4812345678");
        customer = new Customer((CustomerRequest) customerR);

        ingredient1 = new Ingredient("Bun","White bread", 50,BigDecimal.valueOf(1),true, List.of(), List.of());
        ingredient2 = new Ingredient("French Fries","Portion of potato", 50,BigDecimal.valueOf(2),false, List.of(), List.of());
        ingredient3 = new Ingredient("Meet","Spicy Chiken", 150,BigDecimal.valueOf(3),true, List.of(), List.of());
        customSandwich = new CustomSandwich("Vege", List.of(), List.of());
        standardPosition1 = new StandardPosition(ingredient2, 230, List.of());

        menuPositions.add(new MenuPosition("Sandwich", BigDecimal.valueOf(5), true, null, null));
        menuPositions.add(new MenuPosition("French fries", BigDecimal.valueOf(3), true, null, standardPosition1));
        menuPositions.add(new MenuPosition("Vege Sandwich", BigDecimal.valueOf(4), true, customSandwich, null));
        menuPositions.add(new MenuPosition("Meet", BigDecimal.valueOf(2), true, null, null));
        menu = new Menu(menuPositions);

        warehouse = new Warehouse("Main", List.of());
        pickUpPoint1 = new PickUpPoint("Koszykowa", warehouse, menu, new HashMap<>());

        order1 = new Order(OrderStatusEnum.ACCEPTED, false, null, 0, menuPositions, pickUpPoint1);

        payment1 = new Payment(customer, order1, PaymentMethodEnum.CARD, PaymentStatusEnum.SENT);
    }

    //Create all objects needed to perform one order for a customer
    @Test
    public void testMainFlow() {
        order1.calculateTotalCost();
        order1.makeOrder(customer, payment1);
        payment1.makePayment();
        order1.changeStatus(OrderStatusEnum.INPROGRESS);

        assertEquals(menuPositions, order1.getMenuPositions());
        assertEquals(PaymentStatusEnum.CONFIRMED, payment1.getPaymentStatus());

        menuPositions.clear();
        menuPositions.add(new MenuPosition("French fries", BigDecimal.valueOf(3), true, null, standardPosition1));
        order2 = new Order(OrderStatusEnum.ACCEPTED, false, null, 0, menuPositions, pickUpPoint1);
        order2.calculateTotalCost();
        payment2 = new Payment(customer, order2, PaymentMethodEnum.CARD, PaymentStatusEnum.REJECTED);
        order2.makeOrder(customer, payment2);


        assertEquals(false, order2.isPaid());
        assertEquals(PaymentStatusEnum.REJECTED, payment2.getPaymentStatus());
    }

}
