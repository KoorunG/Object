package pracDDD_modify;

public class Reservation {

    private Screening screening;    // 상영에 대한 정보
    private Customer customer;      // 고객에 대한 정보
    private Money fee;              // 요금
    private int audienceCount;      // 관객수 ( 요금 x 관객수 = 총 요금 계산 )

    public Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
        this.screening = screening;
        this.customer = customer;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }
    
}
