package sellingTicketApp;

public class Audience {

    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }

    public Long buy(Ticket ticket){
        return bag.hold(ticket);
    }

     /* public void sellTicketTo(Audience audience){
        if(audience.getBag().hasInvitation()){
            Ticket ticket = getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            Ticket ticket = getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket)*/

    /* public Long Buy(Ticket ticket){
        if(bag.hasInvitation()){
            bag.setTicket(ticket);
            return 0L;
        }
        else {
            bag.minusAmount(ticket.getFee());
            bag.setTicket(ticket);
            return ticket.getFee();
            }  
        }
    }*/
}
