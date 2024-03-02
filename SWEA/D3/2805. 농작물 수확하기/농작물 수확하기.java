import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            // 농장 세팅
            for(int r = 0; r < N; r++) {
                String s = br.readLine();
                for(int c = 0; c < N; c++) {
                    arr[r][c] = s.charAt(c) - '0';
                }
            }


            int sum = 0;
            // 0 ~ ((N + 1) / 2) 까지의 행 탐색
            for(int r = 0; r < (N + 1) / 2; r++) {
                for(int c = (N / 2) - r; c <= (N - 1) / 2 + r; c++) {
                    sum += arr[r][c];
                }
//                System.out.println(r + "행까지의 합 : " + sum);
            }
//            System.out.println("절반까지의 합: " + sum);


            int idx = 1;
            // (N + 3) / 2 ~ N 까지의 행 탐색
            for(int r = (N + 1) / 2; r < N; r++) {
                for(int c = idx; c <= N - 1 - idx; c++) {
                    // r이 증가하면 c도 함께 증가해야 한다. 그러니까 + r로 해야됨
                    // N이 7이라서 (N + 1) / 2 가 4이다.
                    // r = (N + 1) / 2
                    // c = -3 + r
                    sum += arr[r][c];
                }
//                System.out.println(idx + (N - 1) / 2 + "행까지의 합 : " + sum);
                idx++;
            }

            System.out.printf("#%d %d", tc, sum);
            System.out.println();
        }

    }
}