package pracDDD_modify2;

public class ReservationAgency {

    // 몬스터 메소드 reserve()를 잘게 쪼개는 작업!

    // 1. 예약을 만드는 메소드
    public Reservation reserve(Screening screening, Customer customer, int audienceCount){
        Money fee = screening.calculateFee(screening.getDiscountable(), audienceCount);
        return createReservation(screening, customer, audienceCount, fee);  
    }
    // 6. new Reservation()을 만드는 메소드
    private Reservation createReservation(Screening screening, Customer customer, int audienceCount, Money fee) {
        return new Reservation(customer, screening, fee, audienceCount);
    }



    //  // 1. 예약을 만드는 메소드
    //  public Reservation reserve(Screening screening, Customer customer, int audienceCount){
    //     boolean discountable = checkDiscountable(screening);
    //     Money fee = calculateFee(screening, discountable, audienceCount);
    //     return createReservation(screening, customer, audienceCount, fee);   
    // }

    // // 2. 요금을 계산하는 메소드
    // private Money calculateFee(Screening screening, boolean discountable, int audienceCount) {
    //     if(discountable){
    //         return screening.getMovie().getFee().minus(calculateDiscountedFee(screening.getMovie())).times(audienceCount);
    //     }
    //     return screening.getMovie().getFee().times(audienceCount);
    // }

    // // 3. 할인이 가능한지 여부를 검사하는 메소드
    // private boolean checkDiscountable(Screening screening) {
    //     return screening.getMovie().getDiscountConditions().stream().anyMatch(condition -> isDiscountable(condition, screening));
    // }

    // // 4. 어떤 할인이 적용 가능한지 검사하는 메소드, 기간조건과 순번조건에 각각 다른 메소드를 호출한다
    // private boolean isDiscountable(DiscountCondition condition, Screening screening){
    //     if(condition.getType() == DiscountConditionType.PERIOD){
    //         return isSatisfiedByPeriod(condition, screening);
    //     }
    //     return isSatisfiedBySequence(condition, screening);
    // }

    // // 4-1. 순번조건에 만족하는지 검사하는 메소드
    // private boolean isSatisfiedBySequence(DiscountCondition condition, Screening screening) {
    //     return condition.getSequence() == screening.getSequence();
    // }


    // // 4-2. 기간조건에 만족하는지 검사하는 메소드
    // private boolean isSatisfiedByPeriod(DiscountCondition condition, Screening screening) {
    //     return screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) &&   
    //             condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <=0 &&
    //             condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >=0;
    // }
    
    // // 5. 타입별로 할인된 요금을 리턴하는 메소드
    // private Money calculateDiscountedFee(Movie movie){
    //     switch(movie.getMovieType()){
    //                 case AMOUNT_DISCOUNT:
    //                 return calculateAmountDiscountedFee(movie);
                   
    //                 case PERCENT_DISCOUNT:
    //                 return calculatePercentDiscountedFee(movie);
                    
    //                 case NONE_DISCOUNT:
    //                 return calculateNoneDiscountedFee(movie);
    //             }
    //             throw new IllegalArgumentException();
    // }

    // // 5-1. 총액 할인 요금
    // private Money calculateAmountDiscountedFee(Movie movie){
    //     return movie.getDiscountAmount();
    // }
    // // 5-2. 퍼센트 할인 요금
    // private Money calculatePercentDiscountedFee(Movie movie){
    //     return movie.getFee().times(movie.getDiscountPercent());
    // }
    // // 5-3. 할인 없음
    // private Money calculateNoneDiscountedFee(Movie movie){
    //     return Money.ZERO;
    // }



    // // 6. new Reservation()을 만드는 메소드
    // private Reservation createReservation(Screening screening, Customer customer, int audienceCount, Money fee) {
    //     return new Reservation(customer, screening, fee, audienceCount);
    // }
}