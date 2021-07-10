package implementation;

public class AmountDiscountMovie implements DiscountPolicy {

    private Money discountAmount;

    @Override
    public Money calculateDiscountAmount() {
        return discountAmount;
    }
}
