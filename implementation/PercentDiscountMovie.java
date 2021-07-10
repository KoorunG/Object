package implementation;

public class PercentDiscountMovie implements DiscountPolicy {

    private double percent;
    private Movie movie;

    @Override
    public Money calculateDiscountAmount() {
        return movie.getFee().times(percent);         // Movie의 getFee() 메소드를 이용하여 가져왔다 (접근제한자 protected인 메소드)
    }

}
