import java.sql.Array;
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
        list = new ArrayList[N + 1];
        min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
            peoples[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j < num; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        area = new int[N + 1];
        dfs(1);

        if(min == Integer.MAX_VALUE) System.out.println("-1");
        else System.out.println(min);
    }

    public static void dfs(int k) {
        if(k == N + 1) {
            int area1 = 0;
            int area2 = 0;
            for(int i = 1; i <= N; i++) {
                if(area[i] == 1) area1 += peoples[i];
                else area2 += peoples[i];
            }

            visited = new boolean[N + 1];
            int link = 0;
            for(int i = 1; i <= N; i++) {
                if(!visited[i]) {
                    bfs(i, area[i]);
                    link++;
                }
            }

            if(link == 2) min = Math.min(min, Math.abs(area1 - area2));
            return;
        }

        area[k] = 1;
        dfs(k + 1);

        area[k] = 2;
        dfs(k + 1);
    }

    private static void bfs(int idx, int areaNum) {
        Queue<Integer> queue = new LinkedList<>();
        visited[idx] = true;
        queue.offer(idx);

        while(!queue.isEmpty()) {
            int curr = queue.poll();

            for(int i = 0; i < list[curr].size(); i++) {
                int next = list[curr].get(i);
                if(area[next] == areaNum && !visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }

}