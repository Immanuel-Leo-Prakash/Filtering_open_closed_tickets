import java.util.ArrayList;
import java.util.List;

public class Tickets {
    private Agents Agent;                                        //dependency to create object
    private boolean isOpened;
    private final int ticket_id;

    @Override
    public String toString() {
        String status="Closed Ticket";
        if(isOpened)
            status="Open Ticket";
        return "Tickets{" +
                "Ticket ID : "+ticket_id+
                " is a "+status+" assigned to "+
                Agent.getName()+"("+Agent.getRole()+")"+
                '}';
    }


    private static List<Tickets> ticketsList = new ArrayList<>();


    public Tickets(Agents Agent, boolean isOpened) {             //constructor injection
        int min=100000;
        int max=1000000000;
        this.setAgent(Agent);
        this.setOpened(isOpened);
        this.ticket_id=(int)Math.floor(Math.random() *(max - min + 1) + min);
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

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {

        isOpened = opened;
    }

}
