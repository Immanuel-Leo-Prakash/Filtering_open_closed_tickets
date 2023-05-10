import java.util.ArrayList;
import java.util.List;

public class Tickets {
    private Agents Agent;                                        //dependency to create object
    private TicketStatus ticketStatus;
    private final int ticket_id;
    private Departments departments;


    enum TicketStatus {
        OPEN,
        CLOSED,
        ON_HOLD,
        ESCALATED
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
        return
                "Ticket ID : " + ticket_id +
                        " is a " + status + " assigned to " +
                        Agent.getName() + "(" + Agent.getRole() + ")" + " from Department : " +
                        this.getDepartments() +
                        '}';
    }

    private static final List<Tickets> ticketsList = new ArrayList<>();


    public Tickets(Agents Agent, TicketStatus ticketStatus, Departments departments) {             //constructor injection
        int min = 100000;
        int max = 1000000000;
        this.setAgent(Agent);
        this.setStatus(ticketStatus);
        this.departments = departments;
        this.ticket_id = (int) Math.floor(Math.random() * (max - min + 1) + min);
        ticketsList.add(this);
    }

    public static List<Tickets> getAllTickets() {

        return ticketsList;
    }

    public Agents getAgent() {
        return Agent;
    }

    public void setAgent(Agents agent) {
        if (agent == null)
            throw new IllegalArgumentException("Mention the agent");
        Agent = agent;
    }

    public TicketStatus getStatus() {
        return ticketStatus;
    }

    public void setStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

}
