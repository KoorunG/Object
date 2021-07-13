package reservingMovieApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class OverlappedDiscountPolicy implements DiscountPolicy {

    private List<DiscountPolicy> discountPolicies = new ArrayList<>();  // 여러개의 정책을 List로 만든 뒤

    
    public OverlappedDiscountPolicy(DiscountPolicy ... discountPolicies) {  // 이 정책들을 받는 생성자를 만듦
        this.discountPolicies = Arrays.asList(discountPolicies);    // Arrays.asList(discountPolicies)를 이용하여
    }


    @Override
    public Money calculateDiscountAmount(Screening screening) { // 메소드 재정의  
        Money result = Money.ZERO;                              // result를 0으로 초기화 한 뒤,
        for(DiscountPolicy discountPolicy : discountPolicies){  // for - each문을 이용하여 
            result = result.plus(discountPolicy.calculateDiscountAmount(screening));    // 할인 총액을 계산하여 더해줌 ( result = result.plus(Money타입의 ... ))
        }
        return result;
    }
    
}
