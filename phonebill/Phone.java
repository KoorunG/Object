package phonebill;

import java.util.ArrayList;
import java.util.List;

public abstract class Phone {
    
    private List<Call> calls = new ArrayList<>();
    
    public Money calculateFee(){
        Money result = Money.ZERO;
        for(Call call : calls){
            result = result.plus(calculateCallFee(call));
        }
        return afterCalculated(result);
    }

    protected abstract Money calculateCallFee(Call call);    
    protected Money afterCalculated(Money fee) { // 전체 요금을 계산한 후의 동작을 수행할 수 있는 권리 제공
        return fee;
    }
    
}
