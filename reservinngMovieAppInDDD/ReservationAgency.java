package reservinngMovieAppInDDD;

public class ReservationAgency {
    private CalculateDiscountFee calculateDiscountFee;      // 인터페이스를 구현해 다형성을 이용함
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        boolean discountable = checkDiscountable(screening);
        Money fee = calculateFee(screening, discountable, audienceCount);
        
        return createReservation(screening, customer, audienceCount, fee);
    }

    private boolean checkDiscountable(Screening screening) {
        return screening.getMovie().getDiscountConditions().stream()
                .anyMatch(condition -> condition.isDiscountable(condition, screening));
    }

    private Money calculateFee(Screening screening, boolean discountable, int audienceCount) {

        if (discountable) {
            screening.getMovie().getFee().minus(calculateDiscountFee.calculateDiscountFee(screening.getMovie())).times(audienceCount);
        }
        return screening.getMovie().getFee().times(audienceCount);
    }

    private Reservation createReservation(Screening screening, Customer customer, int audienceCount, Money fee) {
        return new Reservation(customer, screening, fee, audienceCount);
    }
        
}

// 40줄에 달하는 몬스터 메소드 reserve -> 응집도가 낮음 => 이해하기 어려움 ; 재사용하기 어려움 ; 변경하기 어려움
// 작고 목적성이 명확하나 메소드들로 잘게 쪼개야함


// reserve를 제외한 나머지는 모두 private 메소드로 만들어, reserve를 보조하게끔 잘게 쪼갰다