import org.jetbrains.annotations.NotNull;

public class Builder {

    //    @Contract(value = " -> new", pure = true)
    public static OpenTicketsFilter OpenFilter() {
        return new OpenTicketsFilter();
    }

    //    @Contract(value = " -> new", pure = true)
    public static CloseTicketsFilter CloseFilter() {
        return new CloseTicketsFilter();
    }

    //    @Contract(value = " -> new", pure = true)
    public static @NotNull OnHoldTicketsFilter OnHoldFilter() {
        return new OnHoldTicketsFilter();
    }

    public static EscalatedTicketsFilter EscalatedFilter() {
        return new EscalatedTicketsFilter();
    }


    public static Tickets getOpenTicket() {
        return new Tickets(AgentBuilder(), Tickets.TicketStatus.OPEN, DepartmentBuilder());
    }

    public static Tickets getCloseTicket() {
        return new Tickets(AgentBuilder(), Tickets.TicketStatus.CLOSED, DepartmentBuilder());
    }

    public static Tickets getEscalatedTicket() {
        return new Tickets(AgentBuilder(), Tickets.TicketStatus.ESCALATED, DepartmentBuilder());
    }

    public static Tickets getOnHoldTicket() {
        return new Tickets(AgentBuilder(), Tickets.TicketStatus.ON_HOLD, DepartmentBuilder());
    }

    public static Agents AgentBuilder() {
        return new Agents("leo", "ADMIN");
    }

    public static Departments DepartmentBuilder() {
        return new Departments("New Joiner", AgentBuilder());
    }
}
