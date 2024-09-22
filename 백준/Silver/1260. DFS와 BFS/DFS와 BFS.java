import java.util.*;
import java.io.*;

public class Main {
    static int N, M, V;
    static int[][] arr;
    static boolean[] visited_bfs;
    static boolean[] visited_dfs;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        visited_bfs = new boolean[N + 1];
        visited_dfs = new boolean[N + 1];

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        dfs(V);
        System.out.println();
        bfs(V);
    }

    static void bfs(int start) {
        q.add(start);
        visited_bfs[start] = true;
        while(!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");
            for(int i = 1; i <= N; i++) {
                if(arr[curr][i] == 1 && !visited_bfs[i]) {
                    q.add(i);
                    visited_bfs[i] = true;
                }
            }
        }
    }

    static void dfs(int start) {
        visited_dfs[start] = true;
        System.out.print(start + " ");

        for(int i = 1; i <= N; i++) {
            if(arr[start][i] == 1 && !visited_dfs[i])
                dfs(i);
        }
    }
}