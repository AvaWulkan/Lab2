package uppgift1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uppgift1.StringCalculator;

public class StringCalculatorTest {

    @Test
    void addTest(){
        StringCalculator testObject = new StringCalculator();

        String numbers1 = "";
        int expected1 = 0;
        int actual = StringCalculator.add(numbers1);
        Assertions.assertEquals(expected1,actual);

        String numbers2 = "1";
        int expected2 = 1;
        actual = StringCalculator.add(numbers2);
        Assertions.assertEquals(expected2,actual);

        String numbers3 = "1,2";
        int expected3 = 3;
        actual = StringCalculator.add(numbers3);
        Assertions.assertEquals(expected3,actual);
    }
}
