package phonebill;

import java.time.Duration;

public class DurationDiscountRule extends FixedFeePolicy {

    public DurationDiscountRule(Duration from, Duration to, Money amount, Duration seconds) {
        super(amount, seconds);
        this.from = from;
        this.to = to;
    }
    private Duration from;
    private Duration to;

    public Money calculate(Call call){
        if(call.getDuration().compareTo(to)>0){
            return Money.ZERO;
        }
        
        if(call.getDuration().compareTo(from)<0){
            return Money.ZERO;
        }

        Phone phone = new Phone(null);
        phone.call(new Call(call.getFrom().plus(from),
                            call.getDuration().compareTo(to) > 0 ? call.getFrom().plus(to) : call.getTo()));
        return super.calculateFee(phone);
        
        // 부모클래스의 calculateFee(phone)는 Phone 클래스를 파라미터로 받기 때문에 이를 재사용하기 위해 데이터를 전달할 용도로 임시 Phone를 만든것이다
        // 사실 코드가 변경되어서 쓸모없는 부분이지만 일단 넘어가자...
    }
}
