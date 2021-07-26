package sellingTicketApp;

public class Theater {
    
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller){
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience){                                               // Theater가 Audience를 받는 메소드
       ticketSeller.sellTo(audience);
    }

   /*
      
        public void enter(Audience audience) {
            if(audience.getBag().hasInvitation()){
                Ticket ticket = ticketSeller.getTicketOffice().getTicket();
                audience.getBag().setTicket(ticket);
            } else { 
                Ticket ticket = ticketSeller.getTicketOffice().getTicket();
                audience.getBag().minusAmount(ticket.getFee());
                ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
                audience.getBag().setTicket(ticket);
            }
        }
    }
    
    문제점 : audience, tickerSeller이 수동적임
    Theater이 너무 많은 의존성을 가지고 있음 -> 변경에 매우 취약
    (Audience, Bag, TicketOffice,Ticket에 모두 의존하고 있다!!)

    */
    
}
