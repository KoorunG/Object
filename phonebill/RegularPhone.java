package phonebill;

import java.time.Duration;
import java.util.List;

public class RegularPhone extends Phone{
    private Money amount;
    private Duration seconds;
  

    public RegularPhone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    public void call(Call call){
        calls.add(call);
    }

    public List<Call> getCalls(){
        return calls;
    }

    public Money getAmount(){
        return amount;
    }

    public Duration getSeconds(){
        return seconds;
    }
    
    @Override
    public Money calculateCallFee(Call call) { // 메소드로 추출!
        return amount.times(call.getDuration().getSeconds()/seconds.getSeconds());
    }


}
