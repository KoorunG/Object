package phonebill;

import java.time.Duration;

public class NightlyDiscountPolicy extends BasicRatePolicy {        // 기본 정책을 상속받는 심야요금정책

    private static final int LATE_NIGHT_HOUR = 22;                  // 필요한 기본 필드를 옮겨온 뒤,
    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;

    
    public NightlyDiscountPolicy(Money nightlyAmount, Money regularAmount, Duration seconds) {      // 생성자를 만들고
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }


    @Override
    protected Money calculateCallFee(Call call) {                   // 기본 정책에 추상메소드로 있는 calculateCallFee를 구현
        if(call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times(call.getDuration().getSeconds()/seconds.getSeconds());
        } 
        return regularAmount.times(call.getDuration().getSeconds()/seconds.getSeconds());
    }
    
}
