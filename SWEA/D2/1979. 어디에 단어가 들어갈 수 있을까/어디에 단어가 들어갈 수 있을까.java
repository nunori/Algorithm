import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken()); // 단어의 길이

            // arr setting
            int[][] arr = new int[N][N];
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    arr[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            // 흰색 : 1    검은색 : 0
            // 검은색에는 단어 못들어가고 흰색에만 길이에 꼭 맞게 들어가야 됨
            int result = 0;
            // 가로로 탐색
            for(int r = 0; r < N; r++) {
                int fit_len = 0; // 연속된 자리 몇 개인지
                for(int c = 0; c < N - 1; c++) { // 가로로 탐색
                    if(arr[r][c] == 1) {
                        fit_len++;
                        if(fit_len == len && arr[r][c+1] != 1) {
                            result++;
                        }
                        if(c == (N - 2) && fit_len == (len - 1) && arr[r][c+1] == 1) {
                            result++;
                        }
                    } else {
                        fit_len = 0;
                    }
                }
            }
            // 세로로 탐색
            for(int c = 0; c < N; c++) {
                int fit_len = 0; // 연속된 자리 몇 개인지
                for(int r = 0; r < N - 1; r++) { // 가로로 탐색
                    if(arr[r][c] == 1) {
                        fit_len++;
                        if(fit_len == len && arr[r+1][c] != 1) {
                            result++;
                        }
                        if(r == (N - 2) && fit_len == (len - 1) && arr[r+1][c] == 1) {
                            result++;
                        }
                    } else {
                        fit_len = 0;
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, result);
        }
    }
}