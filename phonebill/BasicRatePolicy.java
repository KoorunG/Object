package phonebill;

public abstract class BasicRatePolicy implements RatePolicy {

    @Override
    public Money calculateFee(Phone phone) {                // 기본 계산 구현 -> phone에서 getCalls를 이용하여 calls를 불러와서

        Money result = Money.ZERO;
        for(Call call : phone.getCalls()){                  // for-each문을 돌린다
            result.plus(calculateCallFee(call));            // 초기값 ZERO인 result에 for-each문을 이용하여 calculateCallFee(call)를 더해줌
        }
        return result;                                      // result 반환
    }

    protected abstract Money calculateCallFee(Call call);   // BasicRatePolicy의 자식클래스에서 이것을 구현할 수 있게끔 함
    
}
