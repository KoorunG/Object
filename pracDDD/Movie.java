package pracDDD;

import java.time.Duration;
import java.util.List;

public class Movie {
    // 1. 데이터 세팅

    // 공통점
    private String title;
    private Duration runningTime;
    private Money fee;
    
    // 차이점
    private List<DiscountCondition> discountConditions; // 할인 조건을 List를 통해 받아옴
    private MovieType movieType;    // discountPolicy를 MovieType의 형태로 받아옴
    private Money discountAmount;   // 할인 총액을 직접 받아옴 -> Amount 조건에 쓰이는 변수
    private double discountPercent; // 할인율도 받아옴 -> Percent 조건에 쓰이는 변수

    // 2. 외부와 협력을 위해 접근자(GETTER), 수정자(SETTER) 추가

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Duration getRunningTime() {
        return runningTime;
    }
    public void setRunningTime(Duration runningTime) {
        this.runningTime = runningTime;
    }
    public Money getFee() {
        return fee;
    }
    public void setFee(Money fee) {
        this.fee = fee;
    }
    public List<DiscountCondition> getDiscountConditions() {
        return discountConditions;
    }
    public void setDiscountConditions(List<DiscountCondition> discountConditions) {
        this.discountConditions = discountConditions;
    }
    public MovieType getMovieType() {
        return movieType;
    }
    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }
    public Money getDiscountAmount() {
        return discountAmount;
    }
    public void setDiscountAmount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }
    public double getDiscountPercent() {
        return discountPercent;
    }
    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    

    
}
