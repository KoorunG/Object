package implementation;

import java.time.Duration;
import java.util.List;

public class Movie {

    // 요금을 계산하기 위해 필요한 정보 수집

    private MovieType movieType; // enum
    private Money fee;
    private double discountPercent;
    private Money discountAmount;
    private List<DiscountCondition> discountConditions;

    private String title;
    private Duration runningTime;

    public enum MovieType {
        AMOUNT_DISCOUNT, // 금액 할인 정책
        PERCENT_DISCOUNT, // 비율 할인 정책
        NONE_DISCOUNT // 미적용
    }

    public Money calculateMovieFee(Screening screening) {
        // Screening이 발송한 메세지(movie.calculateMovieFee(Screening screening))를 받는 메소드
        // (Money 반환)

        if (isDiscountable(screening)) { // 만일 Discountable 하다면,
            return fee.minus(calculateDiscountAmount()); // 할인요금이 적용된 fee를 반환하고
        }
        return fee; // 아니면 그냥 fee를 반환한다
    }

    private boolean isDiscountable(Screening screening) { // calculateMovieFee()에서만 쓰이므로 private 처리

        // discountCondition에 isSatisfiedBy라는 메세지 전송
        return discountConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening)); // condition을 돌면서
                                                                                                      // 만족하면 true, 아니면
                                                                                                      // false 반환
        // 교재에서는 스트림으로 반환했는데 일단 두고보자...
    }

    private Money calculateDiscountAmount() { // 역시 calculateMovieFee()에서만 쓰이기 때문에 private 처리함
        switch (movieType) { // MovieType 케이스별로 각각의 요금을 계산하는 메소드 호출
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountAmount();
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountAmount();
            case NONE_DISCOUNT:
                return calculateNoneDiscountAmount();
        }

        throw new IllegalArgumentException(); // 형식에 안맞는 경우 예외처리
    }

    private Money calculateAmountDiscountAmount() {
        return discountAmount;
    }

    private Money calculatePercentDiscountAmount() {
        return fee.times(discountPercent);
    }

    private Money calculateNoneDiscountAmount() {
        return Money.ZERO;
    }

}
