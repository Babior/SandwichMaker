import org.byt.constants.OrderStatusEnum;
import org.byt.constants.PaymentMethodEnum;
import org.byt.constants.PaymentStatusEnum;
import org.byt.dto.CustomerRequest;
import org.byt.dto.UserRequest;
import org.byt.entity.Order;
import org.byt.entity.Payment;
import org.byt.entity.PickUpPoint;
import org.byt.entity.Warehouse;
import org.byt.entity.menu.Menu;
import org.byt.entity.menu.MenuPosition;
import org.byt.entity.user.Customer;
import org.byt.entity.user.User;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    private static UserRequest customerR;
    private static List<MenuPosition> menuPositions = new ArrayList<>();
    private static PickUpPoint pickUpPoint1;
    private static Order order1;
    private static Customer customer;
    private static Payment payment1;
    private static Menu menu;
    private static Warehouse warehouse;

    @BeforeClass
    public static void testSetup() {
        customerR = new CustomerRequest("Anastasiya", "Sukach", "anastasiya.sukach@gmail.com",
                "password", "+4812345678");
        customer = new Customer((CustomerRequest) customerR);
        menuPositions.add(new MenuPosition("Sandwich", BigDecimal.valueOf(5), true, null, null));
        menuPositions.add(new MenuPosition("French fries", BigDecimal.valueOf(3), true, null, null));
        menu = new Menu(menuPositions);
        warehouse = new Warehouse("Main", List.of());
        pickUpPoint1 = new PickUpPoint("Koszykowa", warehouse, menu, new HashMap<>());
        order1 = new Order(OrderStatusEnum.ACCEPTED, false, null, 0, menuPositions, pickUpPoint1);

        payment1 = new Payment(customer, order1, PaymentMethodEnum.CARD, PaymentStatusEnum.SENT);
    }

    @Test
    public void testMakeOrder() {
        order1.calculateTotalCost();
        order1.makeOrder(customer, payment1);
        assertEquals(order1, customer.getOrderList().get(order1.getId()));
    }

    @Test
    public void testCalculateTotalCost() {
        assertEquals(BigDecimal.valueOf(8), order1.calculateTotalCost());
    }

    @Test
    public void testCancelOrder() {
        order1.cancelOrder();
        assertEquals(OrderStatusEnum.CANCELLED, order1.viewStatus());
    }

    @Test
    public void testViewStatus() {
        assertEquals(OrderStatusEnum.ACCEPTED, order1.viewStatus());
    }

    @Test
    public void testChangeStatus() {
        order1.changeStatus(OrderStatusEnum.INPROGRESS);
        assertEquals(OrderStatusEnum.INPROGRESS, order1.getOrderStatusEnum());
    }

    @Test
    public void testViewOrderList() {
        Order.getOrders();
    }
}
