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
        if(bag.hasInvitation()){ 
            bag.setTicket(ticket);
            return 0L; 
            } else {
           bag.minusAmount(ticket.getFee());                             // bag : 티켓값만큼 돈이 차감됨 (audience -> bag으로 접근)
           bag.setTicket(ticket);
           return ticket.getFee();                                       // ticketOffice : 티켓값만큼 돈이 플러스됨 (tickerSeller -> tickerOffice로 접근)
            }
    }
}
