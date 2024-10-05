import java.util.*;
class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static int n;
    public int solution(int n, int[][] edge) {
        Solution.n = n;
        arr = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edge.length; i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            arr[u].add(v);
            arr[v].add(u);
        }
        
        int[] result = new int[n + 1];
        visited = new boolean[n + 1];
        
        bfs(1, result);
        
        int max = 0;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, result[i]);
        }
        int resCnt = 0;
        for(int i = 1; i <= n; i++) {
            if(result[i] == max) {
                resCnt++;
            }
        }
        return resCnt;
    }
    
    private static void bfs(int start, int[] res) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        res[start] = 0;
        int cnt = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int next : arr[curr]) {
                if(!visited[next]) {
                    visited[next] = true;
                    res[next] = res[curr] + 1;
                    q.add(next);
                }
            }
        }
    }
}