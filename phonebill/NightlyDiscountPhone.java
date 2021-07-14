package phonebill;

import java.time.Duration;

public class NightlyDiscountPhone extends Phone {
    private static final int LATE_NIGHT_HOUR = 22;
    private Money nightlyAmount;
    // private Money regularAmount;
    // private Duration seconds;
    // private List<Call> calls = new ArrayList<>();
    // private double taxRate;

    
    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        super(regularAmount,seconds);
        this.nightlyAmount = nightlyAmount;
    }

    // public void call(Call call){
    //     calls.add(call);
    // }

    // public List<Call> getCalls(){
    //     return calls;
    // }

    // public Duration getSeconds(){
    //     return seconds;
    // }

    public Money calculateFee(){
        Money result = super.calculateFee();
        Money nightlyFee = Money.ZERO;
        for(Call call : getCalls()){
            if(call.getFrom().getHour() >= LATE_NIGHT_HOUR){
               nightlyFee = nightlyFee.plus(getAmount().minus(nightlyAmount).times(call.getDuration().getSeconds()/getSeconds().getSeconds()));
            } 
        }
        return result.minus(nightlyFee);
    }


}
