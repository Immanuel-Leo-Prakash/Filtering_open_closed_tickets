import java.util.List;
import java.util.stream.Collectors;

public class OpenTickets implements FilterType {

//   private FilterType filterType;

    @Override
    public List<Tickets> getTicketsByFilter(FilterType filtertype) {
        return Filtering.filtering(filtertype,getTickets());
    }

    @Override
    public List<Tickets> getTicketsByFilter() {
        return getTickets();
    }


    private static List<Tickets> getTickets() {
        return Tickets.getAllTickets()
                .stream()
                .filter(ticket -> ticket.getStatus().equals(Tickets.TicketStatus.OPEN))
                .collect(Collectors.toList());
    }

}
