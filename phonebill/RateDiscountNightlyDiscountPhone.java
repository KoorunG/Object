package phonebill;

import java.time.Duration;

public class RateDiscountNightlyDiscountPhone extends NightlyDiscountPhone{

    private Money discountAmount;

    public RateDiscountNightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, Money discountAmount) {
        super(nightlyAmount, regularAmount, seconds);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}
