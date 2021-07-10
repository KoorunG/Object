package implementation;

public class NoneDiscountMovie implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount() {
        return Money.ZERO;
    }
}
