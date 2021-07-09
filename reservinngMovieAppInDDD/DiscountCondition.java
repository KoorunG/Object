package reservinngMovieAppInDDD;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
    
    private DiscountConditionType type;     // 조건 타입 설정
    private int sequence;                   // 순번 조건에서 필요
    private DayOfWeek dayOfWeek;            // 기간 조건에서 필요
    private LocalTime startTime;            // 기간 조건에서 필요
    private LocalTime endTime;              // 기간 조건에서 필요

    public DiscountConditionType getType() {
        return type;
    }

    public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time){      // 할인 가능한지를 평가하는 메소드(기간)
        if(type != DiscountConditionType.PERIOD){                           // 기간조건에 맞지 않는다면
            throw new IllegalArgumentException();                           // IllegalArgumentException 예외 발생시킴
        }
        return this.dayOfWeek.equals(dayOfWeek) &&                          // 아니라면, 조건에 맞는지에 관한 boolean 반환
               this.startTime.compareTo(time) <= 0 &&
               this.endTime.compareTo(time) >= 0;
    }

    public boolean isDiscountable(int sequence){     // 할인 가능한지를 평가하는 메소드(순번)
        if(type != DiscountConditionType.SEQUENCE){ // 순번조건에 맞지 않는다면
            throw new IllegalArgumentException();   // IllegalArgumentException 예외 발생시킴
        }
        return this.sequence == sequence;           // 아니라면, 조건에 맞는지에 관한 boolean 반환
    }
    // public void setType(DiscountConditionType type) {
    //     this.type = type;
    // }
    // public int getSequence() {
    //     return sequence;
    // }
    // public void setSequence(int sequence) {
    //     this.sequence = sequence;
    // }
    // public DayOfWeek getDayOfWeek() {
    //     return dayOfWeek;
    // }
    // public void setDayOfWeek(DayOfWeek dayOfWeek) {
    //     this.dayOfWeek = dayOfWeek;
    // }
    // public LocalTime getStartTime() {
    //     return startTime;
    // }
    // public void setStartTime(LocalTime startTime) {
    //     this.startTime = startTime;
    // }
    // public LocalTime getEndTime() {
    //     return endTime;
    // }
    // public void setEndTime(LocalTime endTime) {
    //     this.endTime = endTime;
    // }


}


