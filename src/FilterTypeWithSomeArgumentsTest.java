import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FilterTypeWithSomeArgumentsTest {
    private OpenTicketsFilter openFilter;
    private CloseTicketsFilter closeFilter;
    private OnHoldTicketsFilter onHoldFilter;
    private EscalatedTicketsFilter escalatedFilter;


    //givenToAllTests
    @BeforeEach
    public void init() {
        openFilter = Builder.OpenFilter();
        closeFilter = Builder.CloseFilter();
        onHoldFilter = Builder.OnHoldFilter();
        escalatedFilter = Builder.EscalatedFilter();
    }

    @ParameterizedTest
    @MethodSource("ArgumentProvider#ContraryArgProvider")
    @DisplayName("Contrary Arguments with One Parameter")
    public void getTicketsByFilters_givenTwoContrary_verifyNoTicketsReturn(FilterType filterType, FilterType ContraryType) {
        //when
        List<Tickets> filteredList = filterType.getTicketsByFilters(ContraryType);

        //then
        assertEquals(0, filteredList.size());
    }

    @Test
    @DisplayName("Null argument should throw NullPointerException")
    public void getTicketsByFilters_givenNullInArgument_ThrowNullPointerException() {

        //then
        assertAll(
                () -> assertThrows(NullPointerException.class,
                        () -> openFilter.getTicketsByFilters(null)),
                () -> assertThrows(NullPointerException.class,
                        () -> closeFilter.getTicketsByFilters(null)),
                () -> assertThrows(NullPointerException.class,
                        () -> onHoldFilter.getTicketsByFilters(null)),
                () -> assertThrows(NullPointerException.class,
                        () -> escalatedFilter.getTicketsByFilters(null))
        );
    }

    @ParameterizedTest
    @MethodSource("ArgumentProvider#NullArgInFiltering")
    public void getTicketsByFilters_givenNullFilterType_ThrowIllegalArgumentException(FilterType filterType, FilterType NullFilter) {

        assertThrows(IllegalArgumentException.class, () -> filterType.getTicketsByFilters(NullFilter));
    }
}