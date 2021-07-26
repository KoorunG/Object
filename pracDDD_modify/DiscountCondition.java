package pracDDD_modify;

import java.time.DayOfWeek;
import java.time.LocalTime;

// 할인조건을 판단하는 클래스

public class DiscountCondition {

    private DiscountConditionType type; // enum

    private int sequence;   // 순번조건에 필요한 변수

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;  // 기간조건에 필요한 변수

    // 할인조건에 할인여부를 판단하는 메소드를 끌어옴

    // 1. 기간 조건일 경우
    public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time){ // 퍼블릭 인터페이스를 통하여 기간조건에 대한 정보가 노출되고 있음
        if(type != DiscountConditionType.PERIOD){
            throw new IllegalArgumentException();
        }
        return this.dayOfWeek.equals(dayOfWeek) &&   // 기간조건의 boolean을 결정하는 코드
        this.startTime.compareTo(time) <=0 &&
        this.endTime.compareTo(time) >=0;
    }
    // 2. 순번 조건일 경우 (메소드 오버로딩)
    public boolean isDiscountable(int sequence){ // 퍼블릭 인터페이스를 통하여 순번조건에 대한 정보가 노출되고 있음
        if(type != DiscountConditionType.SEQUENCE){
            throw new IllegalArgumentException();
        }
        return this.sequence == sequence;
    }

    public DiscountConditionType getType(){
        return type;
    }
}
