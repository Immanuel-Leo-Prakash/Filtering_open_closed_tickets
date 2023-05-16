import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnHoldTicketsFilter implements FilterType {
    @Override
    public List<Tickets> getTicketsByFilters(FilterType... filterType) {
        if (Arrays.asList(filterType).contains(null))
            throw new IllegalArgumentException();
        List<FilterType> list = new ArrayList<>(Arrays.asList(filterType));
        list.add(this);
        return Filtering.filtering(list);
    }
}
