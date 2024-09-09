import java.util.*;
import java.io.*;
public class Main {
    static int N, min;
    static int[] peoples, area;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        peoples = new int[N + 1];
        area = new int[N + 1];
        list = new ArrayList[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++) {
            peoples[i] = Integer.parseInt(st.nextToken());
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for(int j = 0; j < cnt; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        min = Integer.MAX_VALUE;
        dfs(1);
        if(min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);
    }

    private static void dfs(int idx) {
        if(idx == N + 1) {
            int area1 = 0;
            int area2 = 0;
            for(int i = 1; i < N + 1; i++) {
                if(area[i] == 1) area1 += peoples[i];
                else area2 += peoples[i];
            }

            visited = new boolean[N + 1];

            int cnt = 0;
            for(int i = 1; i < N + 1; i++) {
                if(!visited[i]) {
                    bfs(i, area[i]);
                    cnt++;
                }
            }

            if(cnt == 2) min = Math.min(min, Math.abs(area1 - area2));
            return;
        }

        area[idx] = 1;
        dfs(idx + 1);

        area[idx] = 2;
        dfs(idx + 1);
    }

    private static void bfs(int idx, int areaNum) {
        Queue<Integer> q = new LinkedList<>();
        visited[idx] = true;
        q.add(idx);

        while(!q.isEmpty()) {
            int curr = q.poll();

            for(int i = 0; i < list[curr].size(); i++) {
                int next = list[curr].get(i);
                if(!visited[next] && area[next] == areaNum) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}