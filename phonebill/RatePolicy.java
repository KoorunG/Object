package phonebill;

public interface RatePolicy {
    Money calculateFee(Phone phone);    // Phone을 인자로 받아 계산된 요금을 반환하는 calculateFee 오퍼레이션을 포함
}
