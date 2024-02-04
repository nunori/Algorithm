import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N = 5;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // arr 2차원 배열 선언
        String[][] arr = new String[N][15];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = String.valueOf((s.charAt(j)));
            }

        }

        // 열 우선 순회
        for(int j = 0; j < 15; j++) {
            for(int i = 0; i < 5; i++) {
                if(arr[i][j] == null) {
                    continue;
                } else {
                    System.out.print(arr[i][j]);
                }
            }
        }

    }
}