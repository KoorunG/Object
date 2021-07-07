package sellingTicketApp;

public class Theater {
    
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller){
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience){                                               // Theater가 Audience를 받는 메소드
        if(audience.getBag().hasInvitation()){                                          // 1. hasInvitation == true 인 경우
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();                 // ticketSellr -> ticketOffice -> ticket 순으로 접근하여 티켓을 가져옴
            audience.getBag().setTicket(ticket);                                        // audience는 bag으로 접근하여 setTicket(ticket)을 통해 티켓을 가진 상태로 세팅
        } else {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();                 // 2. hasInvitation == false 인 경우
            audience.getBag().minusAmount(ticket.getFee());                             // bag : 티켓값만큼 돈이 차감됨 (audience -> bag으로 접근)
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());                 // ticketOffice : 티켓값만큼 돈이 플러스됨 (tickerSeller -> tickerOffice로 접근)
            audience.getBag().setTicket(ticket);
        }
    }

   /* 문제점 : audience, tickerSeller이 수동적임
      Theater이 너무 많은 의존성을 가지고 있음 -> 변경에 매우 취약 */
}
