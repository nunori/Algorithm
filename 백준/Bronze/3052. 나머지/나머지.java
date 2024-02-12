import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        int[] arr = new int[T];
        for(int i = 0; i < T; i++) {
            int tmp;
            tmp = Integer.parseInt(br.readLine());
            arr[i] = tmp % 42;
        }
        int[] cnt = new int[43];
        for(int i = 0; i < T; i++) {
            cnt[arr[i]]++;
        }

        int diff = 0;
        for(int i = 0; i < 43; i++) {
            if(cnt[i] != 0) {
                diff++;
            }
        }
        System.out.println(diff);
    }
}