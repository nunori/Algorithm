import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int len = S.length();

        // R과 C를 세팅하기만 하면 되는데...
        // 어떻게 해야 할까...

        // R <= C && R * C = len
        int[] R_choose = new int[len];
        int R = 0; // R 초기화
        int C = 0; // C 초기화

        for (int r = len; r > 0; r--) { // R이 큰 값을 찾아야하기 때문에 뒤에서부터 탐색
            // 나머지가 0이면서 len / r 이 C이기 때문에 R <= C인 조건도 함께 고려
            if (len % r == 0 && r <= len / r) {
                R = len / r;
                C = r; // 이 조건이 만족할 때의 값을 R과 C에 대입
                break;
            }
        }
        char[][] arr = new char[R][C];
        int idx = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                arr[r][c] = S.charAt(idx);
                idx++;
            }
        }

//        for (int r = 0; r < R; r++) {
//            for (int c = 0; c < C; c++) {
//                System.out.print(arr[r][c]);
//                idx++;
//            }
//            System.out.println();
//        }

//        System.out.println();

        for (int c = 0; c < C; c++) {
            for (int r = 0; r < R; r++) {
                System.out.print(arr[r][c]);
            }
        }

    }
}