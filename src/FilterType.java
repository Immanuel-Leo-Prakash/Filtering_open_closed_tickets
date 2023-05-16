import java.util.List;
public interface FilterType {
    List<Tickets> getTicketsByFilters(FilterType... filterType);

}
