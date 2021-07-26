package pracDDD_modify2;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;    // 영화에 대한 정보
    private int sequence;   // 순번이 뭔가?
    private LocalDateTime whenScreened; // 언제 상영되는가?
    boolean discountable;

    public int getSequence() {
        return sequence;
    }
    
    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }
    
    public boolean getDiscountable(){
        return discountable;
    }

    // 2. 요금을 계산하는 메소드
    public Money calculateFee(boolean discountable, int audienceCount) {
        if(discountable){
            return movie.getFee().minus(movie.calculateDiscountedFee()).times(audienceCount);
        }
        return movie.getFee().times(audienceCount);
    }    
    
}
