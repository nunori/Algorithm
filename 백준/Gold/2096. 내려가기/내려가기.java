import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] down_min = new int[N][3];
        int[][] down_max = new int[N][3];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                int temp = Integer.parseInt(st.nextToken());
                down_min[i][j] = temp;
                down_max[i][j] = temp;
            }
        } // down 입력 끝

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < 3; j++) {
                if(j == 0) {
                    down_min[i][j] += Math.min(down_min[i-1][j], down_min[i-1][j+1]);
                    down_max[i][j] += Math.max(down_max[i-1][j], down_max[i-1][j+1]);
                } else if(j == 1) {
                    down_min[i][j] += Math.min(Math.min(down_min[i-1][j-1], down_min[i-1][j]), down_min[i-1][j+1]);
                    down_max[i][j] += Math.max(Math.max(down_max[i-1][j-1], down_max[i-1][j]), down_max[i-1][j+1]);
                } else {
                    down_min[i][j] += Math.min(down_min[i-1][j-1], down_min[i-1][j]);
                    down_max[i][j] += Math.max(down_max[i-1][j-1], down_max[i-1][j]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            if(down_max[N-1][i] > max) max = down_max[N-1][i];
            if(down_min[N-1][i] < min) min = down_min[N-1][i];
        }
        System.out.println(max + " " + min);
    }
}