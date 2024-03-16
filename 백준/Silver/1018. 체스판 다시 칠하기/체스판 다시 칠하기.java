import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, cnt, min;
    static boolean check;
    static boolean[][] map, chess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 파리퇴치처럼 배열 두 개 쓰면 될 듯
        map = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            String s = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = (s.charAt(c) == 'W');
            }
        }

        min = Integer.MAX_VALUE;
        for(int r = 0; r <= N - 8; r++) {
            for (int c = 0; c <= M - 8; c++) {
                cnt = 0; // cnt 변수 초기화
                check = map[r][c];
                for(int i = 0; i < 8; i++) { // 8 x 8 배열 도는 구간
                    for(int j = 0; j < 8; j++) {
                        if(map[r + i][c + j] != check) cnt++;
                        check = !check;
                    }
                    check = !check;
                }
                cnt = Math.min(cnt, 64 - cnt);
                // 8 x 8 탐색 끝
                min = Math.min(cnt, min);
            }
        }
        System.out.println(min);
    }
}