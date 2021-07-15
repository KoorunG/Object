package phonebill;

import java.time.Duration;
import java.time.LocalDateTime;

public class Test {
    
    public static void main(String[] args) {
        RegularPhone phone = new RegularPhone(Money.wons(5), Duration.ofSeconds(10));
        phone.call(new Call(LocalDateTime.of(2018, 1, 1, 12, 10, 0), LocalDateTime.of(2018, 1, 1, 12, 11, 0)));
        phone.calculateFee();
        
    }
}
