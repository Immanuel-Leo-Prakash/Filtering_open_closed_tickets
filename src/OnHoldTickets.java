import java.util.List;
import java.util.stream.Collectors;

public class OnHoldTickets implements FilterType{
//    FilterType filterType;
    @Override
    public List<Tickets> getTicketsByFilter(FilterType filterType) {

        return Filtering.filtering(filterType, getTickets());
    }

    @Override
    public List<Tickets> getTicketsByFilter() {
        return getTickets();
    }


    private static List<Tickets> getTickets() {
        return Tickets.getAllTickets()
                .stream()
                .filter(ticket -> ticket.getStatus().equals(Tickets.TicketStatus.ON_HOLD))
                .collect(Collectors.toList());
    }
}