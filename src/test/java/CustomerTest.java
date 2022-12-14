import static org.junit.Assert.assertEquals;

import org.byt.dto.AssistantRequest;
import org.byt.dto.UserRequest;
import org.byt.entity.user.Assistant;
import org.byt.entity.user.Customer;
import org.byt.entity.user.User;
import org.byt.dto.CustomerRequest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerTest {

    private static UserRequest customerRequest1, customerRequest2;

    @BeforeClass
    public static void testSetup() {
        customerRequest1 = new CustomerRequest("Liza", "Babior", "liza.babior@gmail.com",
                "password", "+4812345678");
        customerRequest2 = new CustomerRequest("Lizaveta", "Babior", "liza.babior@gmail.com",
                "password", "+4812345678");
    }

    @Test
    public void testCreateAccount() {
        User customer = new Customer((CustomerRequest) customerRequest1);
        assertEquals(1, Customer.getCustomers().size());
    }

    @Test
    public void testEditAccount() {
        User customer = new Customer((CustomerRequest) customerRequest1);
        customer.editAccount(customerRequest2);
        assertEquals("Lizaveta", customer.getFirstName());
    }
}
