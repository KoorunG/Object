package sellingTicketApp;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience){
        ticketOffice.sellTicketTo(audience);
    }
}

/* TicketOffice의 getTicket 메소드 -> tickets 배열에서 맨 위의 티켓을 꺼내서 반환하는 메소드 ( remove(0) ) 
 buy는 위의 ticket을 받아서 long을 반환하는 메소드이다 (티켓값) 
 따라서 그만큼 ticketOffice가 돈을 버므로 plusAmount로 받는 것임 */

 /* public void sellTo(Audience audience){
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
            }
    } */

   
