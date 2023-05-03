import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

class AgentsTest {

    @Test
    @DisplayName("Constructor behaviour")
    void TestConstructor() {
        String name = "leo";
        String role = "ADMIN";
        Agents agents = new Agents(name, role);
        assertEquals(name, agents.getName());
        assertEquals(role, agents.getRole());
    }

    @Test
    @DisplayName("Name Null Check")
    void agent_name_cant_be_null() {
        assertThrows(IllegalArgumentException.class, () -> new Agents(null, "ADMIN"));
    }

    @Test
    @DisplayName("Name Non-empty Check")
    void agent_name_cant_be_empty() {
        assertThrows(IllegalArgumentException.class, () -> new Agents("", "ADMIN"));
    }

    @Test
    @DisplayName("Role Null Check")
    public void agent_role_cant_be_null() {
        assertThrows(IllegalArgumentException.class, () -> new Agents("Leo", null));

    }

    @Test
    @DisplayName("Role Non-empty Check")
    void agent_role_cant_be_empty() {
        assertThrows(IllegalArgumentException.class, () -> new Agents("Leo", ""));
    }
}