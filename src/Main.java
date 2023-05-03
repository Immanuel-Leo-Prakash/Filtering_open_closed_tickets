public class Main {
    public static void main(String[] args) {
       Agents leo=new Agents("Leo","agent");
       Agents ramki=new Agents("ramki","admin");

       Tickets ticket_1=new Tickets(leo,true);
       Tickets tickets_2=new Tickets(leo,false);
       Tickets tickets_3=new Tickets(ramki,true);
       Tickets tickets_4=new Tickets(ramki,false);


       OpenTickets openTickets= new OpenTickets();
       CloseTickets closeTickets= new CloseTickets();
        System.out.println(openTickets.getTicketsByAgent(leo));
        System.out.println(closeTickets.getTicketsByAgent(leo));
        System.out.println(closeTickets.getTicketsByAgent(ramki));
        System.out.println(openTickets.getTicketsByAgent(ramki));


    }
}