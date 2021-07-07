package sellingTicketApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    public Ticket getTicket() {     // ticket을 판매하는 메소드
        return tickets.remove(0);   // 편의상 tickets 리스트에서 맨 첫번째 위치에 저장된 ticket을 반환하는 것으로 구현
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }

    public void sellTicketTo(Audience audience){
        plusAmount(audience.buy(getTicket()));   
    }
}
