public class Main {
    public static void main(String[] args) {

       //creating agents with name and role;
       Agents leo=new Agents("Leo","agent");
       Agents ramki=new Agents("ramki","admin");

       //creating departments with name and assigned agent's name;
       Departments NewJoiner=new Departments("NewJoiner",leo,ramki);
       Departments DebuggEngineer=new Departments("debugEngineer",ramki);

       //creating tickets with agent, ticket status and department;
       Tickets ticket_1=new Tickets(ramki, Tickets.TicketStatus.CLOSED,NewJoiner);
       Tickets tickets_2=new Tickets(leo, Tickets.TicketStatus.OPEN,NewJoiner);
       Tickets tickets_3=new Tickets(leo, Tickets.TicketStatus.CLOSED,DebuggEngineer);
       Tickets tickets_4=new Tickets(ramki, Tickets.TicketStatus.CLOSED,DebuggEngineer);


       OpenTickets openTickets= new OpenTickets();
       CloseTickets closeTickets= new CloseTickets();
       System.out.println(NewJoiner.getTicketsByFilter(openTickets));
    }
}