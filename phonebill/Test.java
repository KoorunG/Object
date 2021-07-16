package phonebill;

import java.time.Duration;
import java.time.LocalDateTime;

public class Test {
    
    public static void main(String[] args) {
        // RegularPhone regularPhone = new RegularPhone(Money.wons(5), Duration.ofSeconds(10));
        // Call call = new Call(LocalDateTime.of(2018, 1, 1, 12, 10, 0), LocalDateTime.of(2018, 1, 1, 12, 11, 0));
        // System.out.println(regularPhone.calculateFee());

        Phone phoneRegular = new Phone(new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)));
        Phone phoneNightly = new Phone(new NightlyDiscountPolicy(Money.wons(5), Money.wons(10), Duration.ofSeconds(10)));
        Phone phoneComposit1 = new Phone(new TaxablePolicy(new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)), 0.05));   // tax + regular
        Phone phoneCOmposit2 = new Phone(new RateDiscountablePolicy
                                                        (new TaxablePolicy
                                                                 (new NightlyDiscountPolicy(Money.wons(5), Money.wons(10), Duration.ofSeconds(10)), 0.05), Money.wons(1000)));

                                // 심야할인요금 + tax + 기본요금 할인
                                // 여기서 세부 정책 생성자의 순서를 바꾸는것이 조금 더 직관적일수도 있겠다...
        
        
        // 훨씬 직관적이며 유연하다!!
    }
}