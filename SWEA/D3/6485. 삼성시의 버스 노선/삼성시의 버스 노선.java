import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];
            int[] B = new int[N];
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                A[i] = Integer.parseInt(st.nextToken());
                B[i] = Integer.parseInt(st.nextToken());
            }

            int P = Integer.parseInt(br.readLine());
            int[] cnt = new int[5001];
            int[] C = new int[P];
            for(int i = 0; i < P; i++) {
                C[i] = Integer.parseInt(br.readLine());
            }
            for(int i = 0; i < N; i++) {
                for(int j = A[i]; j <= B[i]; j++) {
                    cnt[j]++;
                }
            }
            System.out.print("#" + tc + " ");
            for(int i = 0; i < P; i++) {
                System.out.print(cnt[C[i]] + " ");
            }
            System.out.println();
        }

    }
}