package uppgift1;

import java.util.ArrayList;

public class StringCalculator {
    public static int add(String numbers) {
        int sum = 0;
        String[] splitNumbers;
        String delimiter = "\n|,";
        ArrayList<String> negative = new ArrayList();

        if(numbers.startsWith("//")){
            String[] tempString = numbers.split("\n", 2);
            delimiter = tempString[0].substring(2);
            numbers = tempString[1];
        }
        splitNumbers = numbers.split(delimiter,0);
        for (String num : splitNumbers) {
            if(num.startsWith("-")){
                negative.add(num);
            }else if (!num.equals("")) {
                sum += Integer.parseInt(num);
            }
        }
        if(!negative.isEmpty()){
            throw new RuntimeException("Negatives not allowed " + negative);
        }
        return sum;
    }
}
