package reservingMovieApp;

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

    public LocalDateTime getStartTime(){            // 반면 외부에서 써야할 필요가 있는 메소드의 가시성 : public
        return whenScreened;
    }

    public boolean isSequenced(int sequence){
        return this.sequence == sequence;
    }

    public Money getMovieFee(){
        return movie.getFee();
    }

    public Reservation reserve(Customer customer, int audienceCount){           // customer : 예매자에 대한 정보를 담고 있으며, audienceCount : 인원수
        return new Reservation(customer, this, calculateFee(audienceCount),audienceCount);
    }

    private Money calculateFee(int audienceCount){
        return movie.calculateMovieFee(this).times(audienceCount);          // 인원수에 따른 요금을 계산하는 메소드 (클래스 내부에서만 쓰기 때문에 private 처리)
    }
}
