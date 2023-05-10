import java.util.List;
import java.util.stream.Collectors;

public class Agents implements FilterType{
    private String name;
    private String role;


    public Agents(String name, String role) {
        this.setName(name);
        this.setRole(role);
    }

    @Override
    public String toString() {
        return "Agents{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException();
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if (role == null || role.isEmpty())
            throw new IllegalArgumentException("Agent role is not given");
        this.role = role;
    }
    @Override
    public List<Tickets> getTicketsByFilter(FilterType filterType) {
        return Filtering.filtering(filterType,getTickets());
    }

    @Override
    public List<Tickets> getTicketsByFilter() {
        return getTickets();
    }

    private List<Tickets> getTickets() {
        return Tickets.getAllTickets()
                .stream()
                .filter(ticket -> ticket.getAgent().equals(this))
                .collect(Collectors.toList());
    }
}
