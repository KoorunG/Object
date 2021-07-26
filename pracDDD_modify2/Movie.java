package pracDDD_modify2;

import java.time.Duration;
import java.util.List;

public class Movie {
    // 1. 데이터 세팅

    // 공통점
    private String title;
    private Duration runningTime;
    private Money fee;
    
    // 차이점
    private List<DiscountCondition> discountConditions; // 할인 조건을 List를 통해 받아옴
    private MovieType movieType;    // discountPolicy를 MovieType의 형태로 받아옴
    private Money discountAmount;   // 할인 총액을 직접 받아옴 -> Amount 조건에 쓰이는 변수
    private double discountPercent; // 할인율도 받아옴 -> Percent 조건에 쓰이는 변수

    public Money getFee() {
        return fee;
    }
    public List<DiscountCondition> getDiscountConditions() {
        return discountConditions;
    }

    // 5. 타입별로 할인된 요금을 리턴하는 메소드
    // 외부에서 접근 가능하도록 private -> public
    public Money calculateDiscountedFee(){
        switch(movieType){
                    case AMOUNT_DISCOUNT:
                    return calculateAmountDiscountedFee();
                   
                    case PERCENT_DISCOUNT:
                    return calculatePercentDiscountedFee();
                    
                    case NONE_DISCOUNT:
                    return calculateNoneDiscountedFee();
                }
                throw new IllegalArgumentException();
    }

    // 5-1. 총액 할인 요금
    private Money calculateAmountDiscountedFee(){
        return discountAmount;
    }
    // 5-2. 퍼센트 할인 요금
    private Money calculatePercentDiscountedFee(){
        return fee.times(discountPercent);
    }
    // 5-3. 할인 없음
    private Money calculateNoneDiscountedFee(){
        return Money.ZERO;
    }

    

    
}
