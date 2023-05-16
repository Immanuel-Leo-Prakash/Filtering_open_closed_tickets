public class Main {
    public static void main(String[] args) {
//
        // creating agents with name and role;
        Agents leo = new Agents("Leo", "ADMIN");
        Agents ramki = new Agents("ramki", "MEMBER");

        // creating departments with name and assigned agent's name;
        Departments NewJoiner = new Departments("NewJoiner", leo, ramki);
        Departments DebugEngineer = new Departments("debugEngineer", ramki);

        // creating tickets with agent, ticket status and department;
        Tickets ticket_1 = new Tickets(ramki, Tickets.TicketStatus.CLOSED, NewJoiner);
        Tickets tickets_2 = new Tickets(leo, Tickets.TicketStatus.CLOSED, NewJoiner);
        Tickets tickets_3 = new Tickets(leo, Tickets.TicketStatus.OPEN, DebugEngineer);
        Tickets tickets_4 = new Tickets(ramki, Tickets.TicketStatus.OPEN, DebugEngineer);

        FilterType OpenTickets = new OpenTicketsFilter();
        System.out.println(OpenTickets.getTicketsByFilters());                  //Return all open tickets
        System.out.println(OpenTickets.getTicketsByFilters(leo));               //Return all open tickets of agent leo
        System.out.println(OpenTickets.getTicketsByFilters(leo,NewJoiner));     //Return all open tickets of agent leo in NewJoiner dept

    }
}