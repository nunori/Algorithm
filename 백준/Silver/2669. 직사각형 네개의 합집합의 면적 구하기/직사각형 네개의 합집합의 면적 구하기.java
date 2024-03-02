import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[100][100];

        int T = 4;
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] X = new int[2];
            int[] Y = new int[2];

            for (int i = 0; i < 2; i++) {
                X[i] = Integer.parseInt(st.nextToken());
                Y[i] = Integer.parseInt(st.nextToken());
            }
            for (int x = X[0]; x < X[1]; x++) {
                for (int y = Y[0]; y < Y[1]; y++) {
                    arr[x][y] = 1;
                }
            }
        }

        int cnt = 0;
        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                if (arr[x][y] == 1) cnt++;
            }
        }

        System.out.println(cnt);
    }
}