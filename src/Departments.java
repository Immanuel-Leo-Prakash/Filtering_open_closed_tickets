import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Departments implements FilterType {
    private String name;
    private final List<Agents> associated_agent = new ArrayList<>();

    public Departments(String name, Agents... associated_agent) {
        setName(name);
        setAssociated_agent(associated_agent);
    }

    @Override
    public String toString() {
        return name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null)
            throw new IllegalArgumentException();
        this.name = name;
    }

    public List<Agents> getAssociated_agent() {
        return associated_agent;
    }

    public void setAssociated_agent(Agents... associated_agent) {

        if (associated_agent.length == 0) {
            throw new IllegalArgumentException();
        }
        for (Agents agent : associated_agent) {
            if (agent == null)
                throw new IllegalArgumentException();
            this.associated_agent.add(agent);
        }
    }

    @Override
    public List<Tickets> getTicketsByFilters(FilterType... filterType) {
        if (Arrays.asList(filterType).contains(null))
            throw new IllegalArgumentException();
        List<FilterType> list = new ArrayList<>(Arrays.asList(filterType));
        list.add(this);
        return Filtering.filtering(list);
    }

}
