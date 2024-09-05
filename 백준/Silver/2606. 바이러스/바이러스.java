import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[] visited;
    static int[][] map;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        map = new int[n + 1][n + 1];
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }
        System.out.println(dfs(1));
    }

    static int dfs(int start) {
        visited[start] = true;

        for(int i = 1; i <= n; i++) {
            if(map[start][i] == 1 && !visited[i]) {
                count++;
                dfs(i);
            }
        }
        return count;
    }
}