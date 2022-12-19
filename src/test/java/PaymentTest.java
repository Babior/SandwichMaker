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
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PaymentTest {

    private static Payment payment1, payment2;
    private static UserRequest customerR;
    private static List<MenuPosition> menuPositions = new ArrayList<>();
    private static PickUpPoint pickUpPoint1;
    private static Order order1;
    private static Customer customer;
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
    public void testMakePayment() {
        payment1.makePayment();
        assertEquals(true, order1.isPaid());

    }

    @Test
    public void testChangePaymentStatus(){
        payment1.changePaymentStatus(PaymentStatusEnum.REJECTED);
        assertEquals(PaymentStatusEnum.REJECTED, payment1.getPaymentStatus());
    }

    @Test
    public void testSendConfirmation() {
        payment1.makePayment();
        String message = "Your payment id: " + payment1.getId() + ", date " + payment1.getPaymentDate() +
                ", chosen method: " + payment1.getPaymentMethod() + " was confirmed";
        assertEquals(message, payment1.sendConfirmation(order1));
    }

    @Test
    public void testSendPaymentInfo() {
        String message = "Your payment id: " + payment1.getId() + ", date " + payment1.getPaymentDate() +
                ", chosen method: " + payment1.getPaymentMethod();
        assertEquals(message, payment1.sendPaymentInfo());
    }

    @Test
    public void testSendRejection() {
        payment1.changePaymentStatus(PaymentStatusEnum.REJECTED);
        String message = "Your payment id: " + payment1.getId() + ", date " + payment1.getPaymentDate() +
                ", chosen method: " + payment1.getPaymentMethod() + " was rejected";
        assertEquals(message, payment1.sendRejection(order1));
    }
}
