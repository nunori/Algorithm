import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[N + 1];

        dfs(0, 1);
    }
    private static void dfs(int depth, int start) {
        if(depth == M) {
            for(int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i <= N; i++) {
            arr[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }
}