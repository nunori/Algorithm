import java.util.*;
import java.io.*;

public class Main {
    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static boolean[] visited_dfs;
    static boolean[] visited_bfs;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visited_dfs = new boolean[N + 1];
        visited_bfs = new boolean[N + 1];

        dfs(V);
        System.out.println();
        bfs(V);
    }

    private static void dfs(int node) {
        visited_dfs[node] = true;
        System.out.print(node + " ");
        for(int next : graph[node]) {
            if(!visited_dfs[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int node) {
        q.add(node);
        visited_bfs[node] = true;
        while(!q.isEmpty()) {
            int next = q.poll();
            System.out.print(next + " ");
            for(int n : graph[next]) {
                if(!visited_bfs[n]) {
                    q.add(n);
                    visited_bfs[n] = true;
                }
            }
        }
    }
}