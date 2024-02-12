import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(factorial(Long.parseLong(br.readLine())));
    }

    public static long factorial(long num) {
        if (num <= 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }

}