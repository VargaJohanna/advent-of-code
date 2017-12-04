import java.math.BigInteger;

/**
 * Created by Johanna on 04/12/2017.
 */
public class InverseCaptcha {
    public int solveCaptcha(String input) {
        int output = 0;
        int digit1;
        int digit2;

        for(int i = 0; i < input.length(); i++) {
            digit1 = Character.getNumericValue(input.charAt(i));
            if(i < input.length() - 1) {
                digit2 =  Character.getNumericValue(input.charAt(i + 1));
            } else {
                digit2 =  Character.getNumericValue(input.charAt(0));
            }

            if(digit1 == digit2) {
                output += digit1;
            }
        }
        return output;
    }

    public int solveSecondHalf(String input) {
        int output = 0;
        int digit1;
        int digit2;
        int distance = input.length()/2;

        for(int i = 0; i < input.length(); i++) {
            digit1 = Character.getNumericValue(input.charAt(i));
            if(i < distance) {
                digit2 =  Character.getNumericValue(input.charAt(i + distance));
            } else {
                digit2 =  Character.getNumericValue(input.charAt(i - distance));
            }

            if(digit1 == digit2) {
                output += digit1;
            }
        }
        System.out.println(output);
        return output;
    }
}
