import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FiltersTestWithNoArguments {

    @BeforeAll
    public static void init() {
        //creating tickets and assigning their owner
        Builder.getOpenTicket();
        Builder.getCloseTicket();
        Builder.getOnHoldTicket();
        Builder.getEscalatedTicket();
    }

    @Test
    @DisplayName("Open Filter Should Only Return Open Tickets")
    public void getTicketsByFilters_givenNoArgumentInOpenFilter_verifyTheReturnTicket() {
        //given
        OpenTicketsFilter openFilter = Builder.OpenFilter();

        //When
        List<Tickets> openList = openFilter.getTicketsByFilters();

        //Then
        assertEquals(1, openList.size());

    }

    @Test
    @DisplayName("Close Filter Should Only Return Closed Tickets")
    public void getTicketsByFilters_givenNoArgumentInClosedFilter_verifyTheReturnTicket() {
        //given
        CloseTicketsFilter closeFilter = Builder.CloseFilter();

        //When
        List<Tickets> closedList = closeFilter.getTicketsByFilters();

        //Then
        assertEquals(1, closedList.size());

    }

    @Test
    @DisplayName("OnHold Filter Should Return Only OnHoldTickets")
    public void getTicketsByFilters_givenNoArgumentInOnHoldFilter_verifyTheReturnTicket() {

        //given
        OnHoldTicketsFilter onHoldFilter = Builder.OnHoldFilter();
        //When
        List<Tickets> onHoldList = onHoldFilter.getTicketsByFilters();

        //Then
        assertEquals(1, onHoldList.size());

    }

    @Test
    @DisplayName("Escalated Filter Should Return Only Escalated Tickets")
    public void getTicketsByFilters_givenNoArgumentInEscalatedFilter_verifyTheReturnTicket() {
        //given
        EscalatedTicketsFilter escalatedFilter = Builder.EscalatedFilter();

        //When
        List<Tickets> escalatedList = escalatedFilter.getTicketsByFilters();

        //Then
        assertEquals(1, escalatedList.size());

    }
}