package pracDDD;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount){
        Movie movie = screening.getMovie();
        boolean discountable = false;

        // 1. 할인 여부를 결정하는 코드 
    
        for(DiscountCondition condition : movie.getDiscountConditions()){   // for문으로 돌려 각각의 condition에 이를 결정함
            if(condition.getType() == DiscountConditionType.PERIOD){    // 타입이 기간조건일 때
                discountable = screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) &&   // 기간조건의 boolean을 결정하는 코드
                condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <=0 &&
                condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >=0;
            } else {    // 그렇지 않을 때
                discountable = condition.getSequence() == screening.getSequence(); // 순번조건의 boolean을 결정하는 코드
            }

            if(discountable){   // discoutable == true면
                break;  //  for문을 빠져나온다
            }
        }
        // 2. 요금을 계산하는 코드

        Money fee;
        if(discountable){
            Money discountAmount = Money.ZERO; // 할인요금을 0으로 초기화
            switch(movie.getMovieType()){
                case AMOUNT_DISCOUNT:
                discountAmount = movie.getDiscountAmount();
                break;

                case PERCENT_DISCOUNT:
                discountAmount = movie.getFee().times(movie.getDiscountPercent());
                break;

                case NONE_DISCOUNT:
                discountAmount = Money.ZERO;
                break;
            }

            fee = movie.getFee().minus(discountAmount);
        } else {
            fee= movie.getFee();
        }
        // 3. 새로운 Reservation 생성 (create)
        
        return new Reservation(customer, screening, fee, audienceCount);
    }
}