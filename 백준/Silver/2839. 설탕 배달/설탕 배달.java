import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt_3 = 0;
        int cnt_5 = 0;
        int result = Integer.MAX_VALUE;

        int max_cnt = N / 3 + 1;

        for(int i = 0; i < max_cnt; i++) {
            for(int j = 0; j < max_cnt; j++) {
                if((3 * i) + (5 * j) == N) {
                    cnt_3 = i;
                    cnt_5 = j;
                    result = Math.min(cnt_3 + cnt_5, result);
                }
            }
        }
        if(cnt_3 == 0 && cnt_5 == 0) result = -1;

        System.out.println(result);
    }
}