package pracDDD_modify;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;    // 영화에 대한 정보
    private int sequence;   // 순번이 뭔가?
    private LocalDateTime whenScreened; // 언제 상영되는가?

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Money calculateFee(int audienceCount){
        switch(movie.getMovieType()){
            case AMOUNT_DISCOUNT:
            if(movie.isDiscountable(whenScreened, sequence)){
                return movie.calculateAmountDiscountedFee().times(audienceCount);
            }
            break;
            case PERCENT_DISCOUNT:
            if(movie.isDiscountable(whenScreened, sequence)){
                return movie.calculatePercentDiscountedFee().times(audienceCount);
            }
            break;
            case NONE_DISCOUNT: // 할인정책이 적용되지 않을 때
            return movie.calculateNoneDiscountedFee().times(audienceCount);
        } // 할인이 불가능할 때
        return movie.calculateNoneDiscountedFee().times(audienceCount);

        // DiscountCondition의 isDiscountable 메소드가 바뀐다면?
        // -> Movie의 isDiscountable이 바뀜
        // -> 역시 Screening의 isDiscountable을 호출하는 부분도 수정이 불가피함!!!
        
        // -> 즉 하나의 변경에 여러곳의 코드에 수정을 해야함 (설계의 응집도가 낮다)
    }

}
