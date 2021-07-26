package sellingTicketApp;

public class Bag {

    public Bag(long amount){
        this(null,amount);
    }   // 현금만 보관

    public Bag(Invitation invitation, long amount){
        this.invitation = invitation;
        this.amount = amount;
    }   // 초대장과 현금 모두 보관
    
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    public boolean hasInvitation(){
        return invitation != null;      // 이렇게하면 불리언값을 반환할 수 있구나!
    }

    public boolean hasTicket(){
        return ticket != null;
    }

    public void setTicket(Ticket ticket){
        this.ticket = ticket;
    }

    public void minusAmount(Long amount){
        this.amount -= amount;
    }
    public void plusAmount(Long amount){
        this.amount += amount;
    }

    public Long hold(Ticket ticket){
        if(hasInvitation()){ 
            setTicket(ticket);
            return 0L; 
            } else {
           minusAmount(ticket.getFee());                           
           setTicket(ticket);
           return ticket.getFee();                                      
            }
    }

    
}
