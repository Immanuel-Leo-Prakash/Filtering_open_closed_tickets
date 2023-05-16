import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Agents implements FilterType {
    private String name;
    private String role;


    public Agents(String name, String role) {
        setName(name);
        setRole(role);
    }

    @Override
    public String toString() {
        return "Agents{" + "name='" + name + '\'' + ", role='" + role + '\'' + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException();
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if (role == null || role.isEmpty()) throw new IllegalArgumentException("Agent role is not given");
        this.role = role;
    }

    @Override
    public List<Tickets> getTicketsByFilters(FilterType... filterType) {
        if (Arrays.asList(filterType).contains(null)) throw new IllegalArgumentException();
        List<FilterType> list = new ArrayList<>(Arrays.asList(filterType));
        list.add(this);
        return Filtering.filtering(list);
    }
}
