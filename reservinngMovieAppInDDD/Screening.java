package reservinngMovieAppInDDD;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;             // 인스턴스 변수의 가시성 : private

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Money calculateFee(int audienceCount){
        switch(movie.getMovieType()){
            case AMOUNT_DISCOUNT :
            if(movie.isDiscountable(whenScreened, sequence)){
                return movie.calculateAmountDiscountedFee().times(audienceCount);
            }
            break;
            case PERCENT_DISCOUNT :
            if(movie.isDiscountable(whenScreened,sequence)){
                return movie.calculatePercentDiscountedFee().times(audienceCount);
            }
            break;
            case NONE_DISCOUNT :
                return movie.calculateNoneDiscountedFee().times(audienceCount); // 할인 정책이 적용되지 않은 영화의 경우
            
        }
        return movie.calculateNoneDiscountedFee().times(audienceCount);     //할인이 불가능한 경우 (default)
    }

    // public Movie getMovie() {
    //     return movie;
    // }

    // public void setMovie(Movie movie) {
    //     this.movie = movie;
    // }

    // public int getSequence() {
    //     return sequence;
    // }

    // public void setSequence(int sequence) {
    //     this.sequence = sequence;
    // }

    // public LocalDateTime getWhenScreened() {
    //     return whenScreened;
    // }

    // public void setWhenScreened(LocalDateTime whenScreened) {
    //     this.whenScreened = whenScreened;
    // }

}
