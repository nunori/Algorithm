import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, cnt1, cnt2, fibo[], fibocnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cnt1 = 0;

        fibo = new int[n + 1];
        fib(n);
        System.out.println(cnt1);

        cnt2 = 0;
        fibocnt = 3;
        fibonacci(fibo, n, fibocnt);
        System.out.println(cnt2);
    }

    static int fib(int n) {
        if (n <= 2) {
            cnt1++;
            return 1;
        } else {
            return (fib(n - 1) + fib(n - 2));
        }
    }

    static int fibonacci(int[] arr, int n, int fibocnt) {

        if (fibocnt > n) {
            return cnt2;
        } else {
            fibo[0] = 0;
            fibo[1] = 1;
            fibo[2] = 1;
            for (int i = 3; i <= n; i++) {
                fibo[i] = fibo[i - 1] + fibo[i - 2];
            }
            cnt2++;
            fibocnt++;
            return fibonacci(fibo, n, fibocnt);
        }
    }
}