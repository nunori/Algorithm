import javax.swing.text.SimpleAttributeSet;
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

        dfs(0);
    }

    private static void dfs(int depth) {
        if(depth == M) {
            for(int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                arr[depth] = i;
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}