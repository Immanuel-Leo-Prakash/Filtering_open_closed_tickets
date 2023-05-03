import java.util.List;
import java.util.stream.Collectors;

public class OpenTickets implements Filter{

    Agents agent;

    @Override
    public List<Tickets> getTicketsByAgent(Agents agent) {
        this.agent=agent;
        return filtering();
    }

    @Override 
    public List<Tickets> filtering() {
        return Tickets.getAllTickets()
                .stream()
                .filter(ticket -> ticket.getAgent().equals(agent))
                .filter(Tickets::isOpened)
                .collect(Collectors.toList());
    }
}
