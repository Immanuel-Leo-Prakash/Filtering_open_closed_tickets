import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CloseTicketsTest {
    @Test
    @DisplayName("GetTickets with null agent")
    public void testGetTicketsByAgentWithNullAgent() {
        CloseTickets closeTickets = new CloseTickets();
        List<Tickets> result = closeTickets.getTicketsByAgent(null);
        assertEquals(0, result.size());
    }
    @Test
    @DisplayName("GetTicket with No Open tickets")
    public void testGetTicketsByAgentWithNoMatchingTickets() {
        CloseTickets closeTickets = new CloseTickets();
        Agents agent = new Agents("Powell","Agent");
        List<Tickets> result = closeTickets.getTicketsByAgent(agent);
        assertEquals(0, result.size());
    }
    @Test
    @DisplayName("Test GetTicketByAgent with Matching Tickets")
    public void testGetTicketsByAgentWithMatchingTickets() {
        CloseTickets closeTickets = new CloseTickets();
        Agents agent = new Agents("Davin","lightAgent");
        List<Tickets> allTickets = Tickets.getAllTickets();
        Tickets ticket1 = new Tickets(agent, false);
        Tickets ticket2 = new Tickets( agent, false);
        allTickets.add(ticket1);
        allTickets.add(ticket2);
        List<Tickets> result = closeTickets.getTicketsByAgent(agent);
        assertEquals(2, result.size());
        assertTrue(result.contains(ticket1));
        assertTrue(result.contains(ticket2));
    }


}