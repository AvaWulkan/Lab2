package uppgift1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uppgift1.StringCalculator;
import java.lang.RuntimeException;

public class StringCalculatorTest {

    @Test
    void addTest(){
        StringCalculator testObject = new StringCalculator();

        String numbers1 = "";
        int expected1 = 0;
        int actual = testObject.add(numbers1);
        Assertions.assertEquals(expected1,actual);

        String numbers2 = "1";
        int expected2 = 1;
        actual = testObject.add(numbers2);
        Assertions.assertEquals(expected2,actual);

        String numbers3 = "1,2";
        int expected3 = 3;
        actual = testObject.add(numbers3);
        Assertions.assertEquals(expected3,actual);

        String numbers4 = "1,23,6,7\n2";
        int expected4 = 39;
        actual = testObject.add(numbers4);
        Assertions.assertEquals(expected4,actual);

        String numbers5 = "//-\n432-6-6-67";
        int expected5 = 511;
        actual = testObject.add(numbers5);
        Assertions.assertEquals(expected5,actual);

        String numbers6 = "1,-5,7,-3";
        Assertions.assertThrows(RuntimeException.class,() -> testObject.add(numbers6));

        String numbers7 = "432,6,10005";
        int expected7 = 438;
        actual = testObject.add(numbers7);
        Assertions.assertEquals(expected7,actual);

    }
}
