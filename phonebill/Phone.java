package phonebill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Phone {
    private RatePolicy ratePolicy;          // RatePolicy에 대한 '합성'
    private List<Call> calls = new ArrayList<>();
    
    
    public Phone(RatePolicy ratePolicy) {   // 생성자를 통한 RatePolicy의 인스턴스에 대한 의존성 주입
        this.ratePolicy = ratePolicy;
    }

    public List<Call> getCalls() {
        return Collections.unmodifiableList(calls); // 지정된 목록이 수정 불가능함을 나타내는 Collections.unmodifiableList()
    }
    public Money calculateFee(){
        return ratePolicy.calculateFee(this);
    }

    public void call(Call call) {       // 임시로 만들어두자...
    }

    
}
