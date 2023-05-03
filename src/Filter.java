import java.util.List;

public interface Filter {
    List<Tickets> getTicketsByAgent(Agents agent);

    List<Tickets> filtering();
}
