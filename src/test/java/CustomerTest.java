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

    private static UserRequest customerRequest1, assistantRequest2;

    @BeforeClass
    public static void testSetup() {
        customerRequest1 = new CustomerRequest("Liza", "Babior", "liza.babior@gmail.com",
                "password", "+4812345678");
        assistantRequest2 = new AssistantRequest("Alex", "Mount", "mount@gmail.com",
                "pass", "500", "Koszykowa", "Main");
    }

    @AfterClass
    public static void testCleanup() {
        // Do your cleanup here like close URL connection , releasing resources etc
    }

    @Test
    public void testCreateAccount() {
        User customer = new Customer((CustomerRequest) customerRequest1);
        assertEquals(1, Customer.getCustomers().size());

        User assistant = new Assistant((AssistantRequest) assistantRequest2);
        assertEquals(1, Assistant.getAssistants().size());
    }
}
