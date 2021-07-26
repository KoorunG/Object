package pracDDD_modify;

import java.time.Duration;
import java.time.LocalDateTime;
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


    // Movie에 할인요금 계산을 위해 정책에 따른 세 가지 메소드 추가

    public Money calculateAmountDiscountedFee(){
        if(movieType != MovieType.AMOUNT_DISCOUNT){
            throw new IllegalArgumentException();
        }
        return fee.minus(discountAmount);
    }

    public Money calculatePercentDiscountedFee(){
        if(movieType != MovieType.PERCENT_DISCOUNT){
            throw new IllegalArgumentException();
        }
        return fee.minus(fee.times(discountPercent));
    }

    public Money calculateNoneDiscountedFee(){
        if(movieType != MovieType.NONE_DISCOUNT){
            throw new IllegalArgumentException();
        }
        return fee;
    }
    // 할인 여부를 판단하는 isDiscountable(LocalDateTime whenScreened, int sequence)
    // DiscountCondition의 isDiscountable 메소드를 이용하여 할인조건의 타입을 체크한다
    
    // 단, 퍼블릭 인터페이스에 할인조건의 종류를 노출하고 있기 때문에 캡슐화 측면에서는 안좋은 설게


    // isDiscountable 메소드에서도 캡슐화 측면에서 안좋은 부분이 존재함

    public boolean isDiscountable(LocalDateTime whenScreened, int sequence){
        for(DiscountCondition condition : discountConditions){
            if(condition.getType() == DiscountConditionType.PERIOD){
                if(condition.isDiscountable(whenScreened.getDayOfWeek(), whenScreened.toLocalTime())){
                    return true;
                }
            } else {
                if(condition.isDiscountable(sequence)){
                    return true;
                }
            }
        }
        return false;
    }

    // DiscountCondition의 기간 할인조건의 명칭이 PERIOD에서 다른것으로 변경된다면 코드를 수정해야함
    // DiscountCondition의 종류가 추가되거나 삭제된다면 if - else 구문에 관련 로직을 수정해야함
    // DiscountCondition의 만족여부를 판단하는 isDiscountable에 필요한 정보가 변경된다면, 시그니쳐도 같이 바뀌기 때문에 역시 수정이 필요함
    
    
    public MovieType getMovieType() {
        return movieType;
    }
}
