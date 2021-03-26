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
            numbers = tempString[1];
            String[] temp = tempString[0].substring(2).split("\\[|\\]");
            delimiter = "";
            for (String t : temp) {
                if(t.startsWith("*")||t.startsWith("."))
                    t = "[" + t + "]";
                if(!t.equals(""))
                    delimiter += t + "|";
            }
            delimiter = delimiter.substring(0,delimiter.length()-1);
        }
        splitNumbers = numbers.split(delimiter,0);
        for (String num : splitNumbers) {
            if (num.startsWith("-")) {
                negative.add(num);
            } else if (!num.equals("")) {
                sum += (Integer.parseInt(num) < 1001) ? Integer.parseInt(num) : 0;
            }
        }
        if(!negative.isEmpty()){
            throw new RuntimeException("Negatives not allowed " + negative);
        }
        return sum;
    }
}
