import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OpenTicketsTest {
    @Test
    @DisplayName("GetTickets with null agent")
    public void testGetTicketsByAgentWithNullAgent() {
        OpenTickets openTickets = new OpenTickets();
        List<Tickets> result = openTickets.getTicketsByAgent(null);
        assertEquals(0, result.size());
    }
    @Test
    @DisplayName("GetTicket with No Open tickets")
    public void testGetTicketsByAgentWithNoMatchingTickets() {
        OpenTickets openTickets = new OpenTickets();
        Agents agent = new Agents("Powell","Agent");
        List<Tickets> result = openTickets.getTicketsByAgent(agent);
        assertEquals(0, result.size());
    }
    @Test
    @DisplayName("Test GetTicketByAgent with Matching Tickets")
    public void testGetTicketsByAgentWithMatchingTickets() {
        OpenTickets openTickets = new OpenTickets();
        Agents agent = new Agents("Davin","lightAgent");
        List<Tickets> allTickets = Tickets.getAllTickets();
        Tickets ticket1 = new Tickets(agent, true);
        Tickets ticket2 = new Tickets( agent, true);
        allTickets.add(ticket1);
        allTickets.add(ticket2);
        List<Tickets> result = openTickets.getTicketsByAgent(agent);
        assertEquals(2, result.size());
        assertTrue(result.contains(ticket1));
        assertTrue(result.contains(ticket2));
    }


}