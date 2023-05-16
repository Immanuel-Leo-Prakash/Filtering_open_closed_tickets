import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class TicketsTest {

    @Test
    @DisplayName("Constructor initialisation")
    public void TicketsConstructor_givenValidParams_verifyTheAddedTicket() {
        //given
        Agents agents = Builder.AgentBuilder();
        Departments departments = Builder.DepartmentBuilder();

        //when
        Tickets ticket = new Tickets(agents, Tickets.TicketStatus.OPEN, departments);

        //then
        assertEquals(agents, ticket.getAgent());
        assertEquals(departments, ticket.getDepartments());
        assertEquals(Tickets.TicketStatus.OPEN, ticket.getStatus());
        assertEquals(1, Tickets.getAllTickets().size());
    }

    @ParameterizedTest
    @MethodSource("ArgumentProvider#TicketTestArgProvider")
    public void NullArgumentTest(Agents agents, Tickets.TicketStatus status, Departments departments) {
        assertThrows(IllegalArgumentException.class, () -> new Tickets(agents, status, departments));
    }

}