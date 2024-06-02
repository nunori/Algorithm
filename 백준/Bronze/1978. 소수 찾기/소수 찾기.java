import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) { // arr 배열 돌리기
            int tmp = 0;
            if (arr[i] == 1) continue;
            if (arr[i] == 2) {
                cnt++;
                continue;
            }
            for (int j = 2; j < arr[i]; j++) { // 해당 원소보다 작은 친구들로 나누었을 때
                if (arr[i] % j == 0) { // 나머지가 0이 안돼야지 소수임
                    tmp++;
                }
            }
            if (tmp == 0) cnt++;
        }

        System.out.println(cnt);
    }
}