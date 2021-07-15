package phonebill;

import java.util.ArrayList;
import java.util.List;

public abstract class Phone {
    
    protected List<Call> calls = new ArrayList<>();
    
    public Money calculateFee(){
        Money result = Money.ZERO;
        for(Call call : calls){
            result = result.plus(calculateCallFee(call));
        }
        return result;
    }

    protected abstract Money calculateCallFee(Call call);
    
}
