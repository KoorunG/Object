package reservinngMovieAppInDDD;

public class NoneDiscountedFee implements CalculateDiscountFee {

    @Override
    public Money calculateDiscountFee(Movie movie) {
        return Money.ZERO;
    }
    
}
