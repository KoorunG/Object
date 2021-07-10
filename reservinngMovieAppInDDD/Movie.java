package reservinngMovieAppInDDD;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class Movie {
    
    public String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;
    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;
    
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
        return Collections.unmodifiableList(discountConditions);
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

    public Money calculateAmountDiscountedFee(){                // 할인된 요금의 총액을 계산하는 메소드
        if(movieType != MovieType.AMOUNT_DISCOUNT){
            throw new IllegalArgumentException();
        }
        return fee.minus(discountAmount);                       // 조건에 맞는다면 할인을 적용한 요금을 반환    
    }

    public Money calculatePercentDiscountedFee(){
        if(movieType != MovieType.PERCENT_DISCOUNT){
            throw new IllegalArgumentException();
        }
        return fee.minus(fee.times(discountPercent));
    }

    public Money calculateNoneDiscountedFee(){
        if(movieType != MovieType.NONE_DISCOUNT){
            throw new IllegalArgumentException();
        }
        return fee;
    }

    public boolean isDiscountable(LocalDateTime whenScreened, int sequence){    
                                        // Movie의 isDiscountable(LocalDateTime whenScreened, int sequence) 메소드를 새로 정의함
        for(DiscountCondition condition : discountConditions){  // discountConditions를 돌리는(iterate) for-each문
            if(condition.getType() == DiscountConditionType.PERIOD){    // 1. condition의 type이 '기간' 일때
                if(condition.isDiscountable(whenScreened.getDayOfWeek(),whenScreened.toLocalTime())){
                                        // DiscountCondition의 isDiscountable(DayOfWeek dayOfWeek, LocalTime time) 메소드를 불러옴
                    return true;
                }
            } else {
                if(condition.isDiscountable(sequence)){ // 2. condition의 type이 '기간'이 아닐때 -> '시퀀스' 일때
                                        // DiscountCondition의 isDiscountable(int sequence) 메소드를 불러옴
                    return true;
                }
            }
        }

        return false;
    }
}


