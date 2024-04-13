import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N > 1) func(N);
        else System.out.println(666);
    }

    public static void func(int n) {
        int cnt = 1;
        int digit = 0;
        int num = 0;

        while (true) {
            if (((digit % 10000) / 10) == 666 && digit % 10 != 6) {
                for (int i = 0; i < 1000; i++) {
                    if (cnt == n) {
                        System.out.println(digit * 1000 + num);
                        return;
                    }
                    num++;
                    cnt++;
                }
                digit++;
            } else if (digit % 1000 == 666) {
                num = 0;
                for (int i = 0; i < 1000; i++) {
                    if (cnt == n) {
                        System.out.println(digit * 1000 + num);
                        return;
                    }
                    num++;
                    cnt++;
                }
                digit++;
            } else if (digit % 100 == 66) {
                num = 600;
                for (int i = 0; i < 100; i++) {
                    if (cnt == n) {
                        System.out.println(digit * 1000 + num);
                        return;
                    }
                    num++;
                    cnt++;
                }
                digit++;
            } else if (digit % 10 == 6) {
                num = 660;
                for(int i = 0; i < 10; i++) {
                    if(cnt == n) {
                        System.out.println(digit * 1000 + num);
                        return;
                    }
                    num++;
                    cnt++;
                }
                digit++;
            } else {
                num = 666;
                if (cnt == n) {
                    System.out.println(digit * 1000 + num);
                    return;
                }
                cnt++;
                digit++;
            }
        }
    }
}