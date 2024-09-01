import java.util.*;
import java.io.*;

public class Main {
    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];

        for(int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 0; c < 3; c++) {
                cost[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < N; i++) {
            cost[i][Red] += Math.min(cost[i-1][Green], cost[i-1][Blue]);
            cost[i][Green] += Math.min(cost[i-1][Red], cost[i-1][Blue]);
            cost[i][Blue] += Math.min(cost[i-1][Red], cost[i-1][Green]);
        }

        System.out.println(Math.min(Math.min(cost[N-1][Red], cost[N-1][Green]), cost[N-1][Blue]));
    }

}