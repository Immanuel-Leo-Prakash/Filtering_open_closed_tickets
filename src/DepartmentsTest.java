import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentsTest {

    @Test
    @DisplayName("Agents Are Assigned To The Department")
    void DepartmentConstructor_givenTheValidAgents_verifyTheAgentsAssignedToThatDepartment() {
        //given
        Agents agents = Builder.AgentBuilder();
        Agents agents1 = Builder.AgentBuilder();

        //when
        Departments departments = new Departments("New Department", agents1, agents);

        //then
        assertEquals("New Department", departments.getName());
        assertEquals(2, departments.getAssociated_agent().size());

    }

    @Test
    @DisplayName("Null DepartmentName Should Throw Exception")
    public void DepartmentConstructor_givenTheNullDepartmentName_ThrowsIllegalArgumentException() {
        //given
        String DepartmentName = null;
        Agents agents = Builder.AgentBuilder();

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> new Departments(DepartmentName, agents));
    }

    @Test
    @DisplayName("When Agent List Be Null")
    public void DepartmentConstructor_givenAgentsAssignedToDepartmentBeNull_NullPointerException() {
        //given
        String Department_name = "new Joiner";

        //when

        //then
        assertThrows(NullPointerException.class, () -> new Departments(Department_name, null));
    }

    @Test
    @DisplayName("Null agents assigned to the department created")
    public void DepartmentConstructor_givenAgentsAssignedToDepartmentBeNull_ThrowsIllegalArgumentException() {
        //given
        String Department_name = "new Joiner";
        Agents agents = null;

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> new Departments(Department_name, agents));
    }
}