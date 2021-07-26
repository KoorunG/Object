package pracDDD;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {

    private DiscountConditionType type; // enum

    private int sequence;   // 순번조건에 필요한 변수

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;  // 기간조건에 필요한 변수

    // GETTER, SETTER
    
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
