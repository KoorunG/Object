package phonebill;

import java.util.ArrayList;
import java.util.List;

public class Phone {
    private RatePolicy ratePolicy;          // RatePolicy에 대한 '합성'
    private List<Call> calls = new ArrayList<>();
    
    
    public Phone(RatePolicy ratePolicy) {   // 생성자를 통한 RatePolicy의 인스턴스에 대한 의존성 주입
        this.ratePolicy = ratePolicy;
    }

    public Money calculateFee(){
        return ratePolicy.calculateFee(this);
    }

    public List<Call> getCalls() {
        return calls;
    }
    
}
