package reservingMovieApp;

public class AmountDiscountPolicy extends DiscountPolicy {

    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition ... conditions) {       // 파라미터 순서에 따라 오류가 발생한다... ?????
                                                                                                // super(conditions)는 맨 위에 와야한다, 따라서 conditions 인자를 받는 파라미터 또한 앞에 와야한다
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
    
}
