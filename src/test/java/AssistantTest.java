import org.byt.dto.AssistantRequest;
import org.byt.dto.UserRequest;
import org.byt.entity.user.Assistant;
import org.byt.entity.user.User;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AssistantTest {
    private static UserRequest assistantRequest1, assistantRequest2;

    @BeforeClass
    public static void testSetup() {
        assistantRequest1 = new AssistantRequest("Alex", "Mount", "mount@gmail.com",
                "pass", "500", "Koszykowa", "Main");

        assistantRequest1 = new AssistantRequest("Alexander", "Mount", "mount@gmail.com",
                "pass", "500", "Koszykowa", "Main");
    }

    @Test
    public void testCreateAccount() {
        User assistant = new Assistant((AssistantRequest) assistantRequest1);
        assertEquals(1, Assistant.getAssistants().size());
    }

    @Test
    public void testEditAccount() {
        User assistant = new Assistant((AssistantRequest) assistantRequest1);
        assistant.editAccount(assistantRequest2);
        assertEquals("Alexander", assistant.getFirstName());
    }

    @Test
    public void testCalculateSalary() {

    }
}
