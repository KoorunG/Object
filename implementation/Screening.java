package implementation;

import java.time.LocalDateTime;

public class Screening {
    
    // '예매하라'라는 메세지 수신 -> reserve 메소드
    public Reservation reserve(Customer customer, int audienceCount){
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount); // Reservation 인스턴스를 만드는 creater 패턴
    }

    // 책임이 결정됐으므로 책임을 수행하는데 필요한 인스턴스 변수 결정
    /* 상영시간(whenScreened), 상영 순번(sequence) 그리고
        Movie에 '요금을 계산하라' 라는 메세지를 전송해야 하므로 Movie도 참조해야함 */
    private LocalDateTime whenScreened;
    private int sequence;
    private Movie movie;

    // '요금을 계산하라' 라는 메세지 전송 -> calculateFee 메소드
    public Money calculateFee(int audienceCount){
        return movie.calculateMovieFee(this).times(audienceCount);       // 요금 : 영화의 요금 x 관객 수
                    // calculateMovieFee()의 시그니쳐를 Screening screening으로 표현 했는데 그 이유는?
                    // Screening이 Movie의 내부 구현에 대해 어떠한 정보 없이 전송할 메세지 결정 -> 이로 인해 캡슐화가 깔끔하게 됨 
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public int getSequence(){
        return sequence;
    }
    
}
