package phonebill;

import java.time.Duration;

public class RegularPhone extends Phone{
    private Money amount;
    private Duration seconds;
  

    public RegularPhone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }
    
    @Override
    protected Money calculateCallFee(Call call) { // 메소드로 추출!
        return amount.times(call.getDuration().getSeconds()/seconds.getSeconds());
    }

}
