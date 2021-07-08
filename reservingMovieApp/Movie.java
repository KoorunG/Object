package reservingMovieApp;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public void changeDiscountPolicy(DiscountPolicy discountPolicy){
        this.discountPolicy = discountPolicy;
    }                                                                   // discountPolicy를 간단하게 바꿀수 있는 메소드 (상속보다 합성이 훨씬 유연함을 알 수 있다)

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }


    public Money getFee(){
        return fee;
    }

    public Money calculateMovieFee(Screening screening){
        // if(discountPolicy == null){
        //     return fee;                                              // 할인요금을 계산할 책임은 DiscountPolicy(와 그 자식클래스)에 있는 반면,
        // }                                                            // discountPolicy == null 일경우 할인요금이 0원이라는 계산을 할 책임만 movie에 지게 하는 것은 좋지 못함

        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    
}
