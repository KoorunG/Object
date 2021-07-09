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
    public void setType(DiscountConditionType type) {
        this.type = type;
    }
    public int getSequence() {
        return sequence;
    }
    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}


