package implementation;

public class SequenceCondition implements DiscountCondition {

    private int sequence;               // 순번조건

    
    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    public boolean isSatisfiedBy(Screening screening) {    // 순번조건 : screening에서 getSequence()로 가져온 것과 비교하여 boolean 반환
        return screening.getSequence() == sequence;                 // 순번조건을 판단하는 로직을 변경하려면 이 메소드의 내부구현을 수정해야함
    }
}
