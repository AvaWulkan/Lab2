package uppgift1;

public class StringCalculator {
    public static int add(String numbers) {
        int sum = 0;
        String[] splitNumbers = numbers.split("\n|,", 0);
        for (String num : splitNumbers) {
            if (!num.equals("")) {
                sum += Integer.parseInt(num);
            }
        }
        return sum;
    }
}
