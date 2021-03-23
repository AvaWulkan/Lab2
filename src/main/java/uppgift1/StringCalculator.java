package uppgift1;

public class StringCalculator {
    public static int add(String numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length(); i+=2) {
            char charNumber = numbers.charAt(i);
            int intNumber = Integer.parseInt(String.valueOf(charNumber));
            sum += intNumber;
        }
        return sum;
    }
}
