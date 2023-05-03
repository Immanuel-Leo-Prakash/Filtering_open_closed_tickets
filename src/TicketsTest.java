import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicketsTest {

    @Test
    @DisplayName("New Ticket Added To The List")
    void create_ticket_adds_ticket_to_list() {

        Agents agent = new Agents("John", "ADMIN");
        boolean isOpened = true;

        Tickets ticket = new Tickets(agent, isOpened);

        List<Tickets> allTickets = Tickets.getAllTickets();
        assertTrue(allTickets.contains(ticket));
    }
}