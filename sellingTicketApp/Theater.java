package sellingTicketApp;

public class Theater {
    
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller){
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience){                                               // Theater가 Audience를 받는 메소드
       ticketSeller.sellTo(audience);
    }

   /* 문제점 : audience, tickerSeller이 수동적임f
      Theater이 너무 많은 의존성을 가지고 있음 -> 변경에 매우 취약 */
}
