import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int n;
    static int[][] computers;
    
    public int solution(int n, int[][] computers) {
        Solution.n = n;
        Solution.computers = computers;
        visited = new boolean[n];
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(i);
                cnt++;
            }
        }
        return cnt;
    }
    
    static void bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;
        while(!queue.isEmpty()) {
            int value = queue.poll();
            for(int j = 0; j < n; j++) {
                if(!visited[j] && computers[value][j] == 1) {
                    queue.add(j);
                    visited[j] = true;
                }
            }
        } 
    }
}
