import java.util.List;

public interface FilterType {
    List<Tickets> getTicketsByFilter(FilterType filterType);
    List<Tickets> getTicketsByFilter();
// List<Tickets> getTickets();
}
