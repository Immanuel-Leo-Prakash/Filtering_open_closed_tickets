import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Tickets {

    // dependency to create object

    private Agents Agent;
    private TicketStatus ticketStatus;
    private final int ticket_id;
    private Departments departments;
    private static final List<Tickets> ticketsList = new ArrayList<>();

    // Ticket status defined as enum;
    enum TicketStatus {
        OPEN, CLOSED, ON_HOLD, ESCALATED
    }

    // constructor injection;

    public Tickets(Agents Agent, TicketStatus ticketStatus, Departments departments) {
        int min = 100000;
        int max = 1000000000;
        setAgent(Agent);
        setStatus(ticketStatus);
        setDepartments(departments);
        this.ticket_id = (int) Math.floor(Math.random() * (max - min + 1) + min);
        ticketsList.add(this);
    }

    public static List<Tickets> getAllTickets() {

        return Collections.unmodifiableList(ticketsList);
    }

    public Agents getAgent() {
        return Agent;
    }

    public void setAgent(Agents agent) {
        if (agent == null)
            throw new IllegalArgumentException();
        Agent = agent;
    }

    public TicketStatus getStatus() {
        return ticketStatus;
    }

    public void setStatus(TicketStatus ticketStatus) {
        if (ticketStatus == null)
            throw new IllegalArgumentException();
        this.ticketStatus = ticketStatus;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        if (departments == null)
            throw new IllegalArgumentException();

        this.departments = departments;
    }

    @Override
    public String toString() {
        String status = "Closed Ticket";
        if (ticketStatus.equals(TicketStatus.OPEN))
            status = "Open Ticket";
        else if (ticketStatus.equals(TicketStatus.ON_HOLD))
            status = "ON_HOLD Ticket";
        else if (ticketStatus.equals(TicketStatus.ESCALATED))
            status = "ESCALATED Ticket";
        return "Ticket ID : " + ticket_id + " is a " + status + " assigned to " + Agent.getName() + "("
                + Agent.getRole() + ")" + " from Department : " + this.getDepartments();
    }


}
