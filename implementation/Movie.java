package implementation;

import java.time.Duration;
import java.util.List;
import java.util.Arrays;

public class Movie {

    // 요금을 계산하기 위해 필요한 정보 수집

    private Money fee;
    private List<DiscountCondition> discountConditions;

    private String title;
    private Duration runningTime;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountCondition ... discountConditions) { 
        this.fee = fee;
        this.discountConditions = Arrays.asList(discountConditions);
        this.title = title;
        this.runningTime = runningTime; 
    }

    public Money calculateMovieFee(Screening screening) {
        // Screening이 발송한 메세지(movie.calculateMovieFee(Screening screening))를 받는 메소드 
        // (Money 반환)

        if (isDiscountable(screening)) { // 만일 Discountable 하다면,
            return fee.minus(discountPolicy.calculateDiscountAmount()); // 할인요금이 적용된 fee를 반환하고
        }
        return fee; // 아니면 그냥 fee를 반환한다 
    }

    private boolean isDiscountable(Screening screening) { // calculateMovieFee()에서만 쓰이므로 private 처리

        // discountCondition에 isSatisfiedBy라는 메세지 전송
        return discountConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening)); // condition을 돌면서
                                                                                                      // 만족하면 true, 아니면
                                                                                                      // false 반환
        // 교재에서는 스트림으로 반환했는데 일단 두고보자...  
    }

    public Money getFee(){
        return fee;
    }

    public void changeDiscountPolicy(DiscountPolicy discountPolicy){
        this.discountPolicy = discountPolicy;
    }

    // protected abstract Money calculateDiscountAmount(); 
    //         // Movie에 대한 추상메소드를 구현하며, Money를 반환하는 메소드를 가지고 있는 클래스 3개를 생성...

}
