package reservingMovieApp;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public void changeDiscountPolicy(DiscountPolicy discountPolicy){    // discountPolicy와의 컴파일타임 의존성(역할)을 명시한 것...
                                                                        // 나중에 어떤 런타임 의존성(객체)으로 대체하느냐에 따라 문맥(context)이 달라짐
                                                                        // => 의존성 해결(컴파일타임 의존성 -> 구체적인 런타임 의존성으로 대체되는것)
        this.discountPolicy = discountPolicy;
    }                                                                   // discountPolicy를 간단하게 바꿀수 있는 메소드 (상속보다 합성이 훨씬 유연함을 알 수 있다)

    // public Movie(String title, Duration runningTime, Money fee){
    //     this(title,runningTime,fee,null);
    // }
    
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
        // if(discountPolicy == null){     // Movie(String title, Duration runningTime, Money fee) 생성자로 만든 경우 
        //                                 // discountPolicy가 null이 되버리기 때문에 이 경우, 할인정책을 적용하면 안됨
        //     return fee;                 // 할인요금을 계산할 책임은 DiscountPolicy(와 그 자식클래스)에 있는 반면,
        // }                               // discountPolicy == null 일경우 할인요금이 0원이라는 계산을 할 책임만 movie에 지게 하는 것은 좋지 못함
        //                                 // 따라서 할인요금이 없을 경우인 NoneDiscountPolicy를 자식클래스로 만드는 것이 객체지향적으로 더 옳다

        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    
}
