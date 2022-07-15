import java.io.IOException;
import java.util.Arrays;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'reverseInParentheses' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING a as parameter.
     */

    public static String reverseInParentheses(String a) {
        // Write your code here
        a = a.replace("(","(*");
        String[] list = a.split("(\\(|\\))");

        return Arrays.stream(list)
                .map(c -> {
                    if(c.contains("*")) {
                        StringBuilder sb = new StringBuilder(c);
                        return sb.reverse().toString().replace("*", "");
                    }
                    return c;
                }).collect(joining());
    }

}

public class ReverseString {
    public static void main(String[] args) throws IOException {
        String a = "algoaqui(bar)algoaca(foo)";

        String result = Result.reverseInParentheses(a);

        System.out.println(result);
    }
}
