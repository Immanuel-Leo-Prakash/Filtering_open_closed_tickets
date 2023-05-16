import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filtering {

    // using private method to apply filters

    public static List<Tickets> filtering(List<FilterType> filterlist) {
        int i = 0;
        List<Tickets> list = new ArrayList<>(Tickets.getAllTickets());

        while (i < filterlist.size())
            list = filtering(filterlist.get(i++), list);
        return list;
    }

    // private method to apply filter on requirements;

    private static List<Tickets> filtering(FilterType filterType, List<Tickets> ticketsList) {

        if (filterType instanceof Agents)
            return ticketsList
                    .stream()
                    .filter(ticket -> ticket.getAgent().equals(filterType))
                    .collect(Collectors.toList());
        if (filterType instanceof OpenTicketsFilter)
            return ticketsList
                    .stream()
                    .filter(ticket -> ticket.getStatus().equals(Tickets.TicketStatus.OPEN))
                    .collect(Collectors.toList());
        if (filterType instanceof CloseTicketsFilter)
            return ticketsList
                    .stream()
                    .filter(ticket -> ticket.getStatus().equals(Tickets.TicketStatus.CLOSED))
                    .collect(Collectors.toList());
        if (filterType instanceof EscalatedTicketsFilter)
            return ticketsList
                    .stream()
                    .filter(ticket -> ticket.getStatus().equals(Tickets.TicketStatus.ESCALATED))
                    .collect(Collectors.toList());
        if (filterType instanceof OnHoldTicketsFilter)
            return ticketsList
                    .stream()
                    .filter(ticket -> ticket.getStatus().equals(Tickets.TicketStatus.ON_HOLD))
                    .collect(Collectors.toList());
        if (filterType instanceof Departments)
            return ticketsList
                    .stream()
                    .filter(ticket -> ticket.getDepartments().equals(filterType))
                    .collect(Collectors.toList());
        return new ArrayList<>();
    }

}
