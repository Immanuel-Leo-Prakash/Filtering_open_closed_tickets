import java.util.List;
import java.util.stream.Collectors;

public class Filtering {
//    private static FilterType filterType;

    public static List<Tickets> filtering(FilterType filterType, List<Tickets> ticketsList){

        if(filterType instanceof Agents)
            return ticketsList
                    .stream()
                    .filter(ticket -> ticket.getAgent().equals(filterType))
                    .collect(Collectors.toList());
        if(filterType instanceof OpenTickets)
            return ticketsList
                    .stream()
                    .filter(ticket->ticket.getStatus().equals(Tickets.TicketStatus.OPEN))
                    .collect(Collectors.toList());
        if(filterType instanceof CloseTickets)
            return ticketsList
                    .stream()
                    .filter(ticket->ticket.getStatus().equals(Tickets.TicketStatus.CLOSED))
                    .collect(Collectors.toList());
        if(filterType instanceof EscalatedTickets)
            return ticketsList
                    .stream()
                    .filter(ticket->ticket.getStatus().equals(Tickets.TicketStatus.ESCALATED))
                    .collect(Collectors.toList());
        if(filterType instanceof OnHoldTickets)
            return ticketsList
                    .stream()
                    .filter(ticket->ticket.getStatus().equals(Tickets.TicketStatus.ON_HOLD))
                    .collect(Collectors.toList());
        if(filterType instanceof Departments)
            return ticketsList
                    .stream()
                    .filter(ticket->ticket.getDepartments().equals(filterType))
                    .collect(Collectors.toList());

        return null;
        }


    }

