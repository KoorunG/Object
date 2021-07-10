package implementation;

public interface DiscountCondition {
   
    public boolean isSatisfiedBy(Screening screening);        // Movie가 보낸 isSatisfiedBy 메세지 수신 (시그니쳐가 Screening)
    
}
    // 즉, 이 클래스에서 기간조건이나 순번조건을 확인하는 메소드가 '서로 다른 이유'로 변경되기 때문에 응집도가 낮다고 볼 수 있다.
    // 인스턴스 변수가 초기화되는 시점이 제각각이다 -> 응집도가 낮다 (여기서는 순번조건이 초기화되도 기간조건은 그대로 남아있음)
    // 함께 초기화되는 속성을 기준으로 코드를 분리해야한다
    // 메소드들이 인스턴스변수를 사용하는 방식을 살펴보는것도 응집도 판단에 도움이 된다 (메소드들이 사용하는 속성에 따라 그룹이 나뉜다면 클래스의 응집도가 낮은것)

    // 해결방안 : SequenceCondition과 PeriodCondition이라는 두 클래스로 분리


    

