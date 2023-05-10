import sun.management.resources.agent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Departments implements FilterType {
    private String name;
    private List<Agents> associated_agent;


    public Departments(String name, Agents... associated_agent) {
        this.setName(name);
        this.setAssociated_agent(associated_agent);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Agents> getAssociated_agent() {
        return associated_agent;
    }

    public void setAssociated_agent(Agents... associated_agent) {
        this.associated_agent = new ArrayList<>();
        if (associated_agent.length == 0)
            throw new IllegalArgumentException();
        for (Agents agent : associated_agent) {
            this.associated_agent.add(agent);
        }
    }

    @Override
    public List<Tickets> getTicketsByFilter(FilterType filterType) {
        return Filtering.filtering(filterType, getTicketsByFilter());
    }

    @Override
    public List<Tickets> getTicketsByFilter() {
        return getTickets();
    }

    private List<Tickets> getTickets() {
        return Tickets.getAllTickets()
                .stream()
                .filter(ticket -> ticket.getDepartments().equals(this))
                .collect(Collectors.toList());
    }
}
