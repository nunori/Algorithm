import java.util.*;
import java.io.*;

public class Main {
    static int k, w, h, min;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dnr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dnc = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    private static class Node {
        int x;
        int y;
        int cnt;
        int k;
        public Node(int x, int y, int cnt, int k) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.k = k;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][w];
        min = Integer.MAX_VALUE;

        for(int r = 0; r < h; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < w; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[h][w][k + 1];
        min = bfs(0, 0);

        if(min == Integer.MAX_VALUE) System.out.println("-1");
        else System.out.println(min);
    }

    private static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 0, k));
        visited[x][y][k] = true;

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            if(curr.x == h - 1 && curr.y == w - 1) return curr.cnt;

            for(int d = 0; d < 4; d++) {
                int nr = curr.x + dr[d];
                int nc = curr.y + dc[d];
                if(nr >= 0 && nr < h && nc >= 0 && nc < w && !visited[nr][nc][curr.k] && map[nr][nc] == 0) {
                        visited[nr][nc][curr.k] = true;
                        queue.offer(new Node(nr, nc, curr.cnt + 1, curr.k));
                }
            }

            if(curr.k > 0) {
                for(int d = 0; d < 8; d++) {
                    int nr = curr.x + dnr[d];
                    int nc = curr.y + dnc[d];
                    if(nr >= 0 && nr < h && nc >= 0 && nc < w && !visited[nr][nc][curr.k - 1] && map[nr][nc] == 0) {
                            visited[nr][nc][curr.k - 1] = true;
                            queue.offer(new Node(nr, nc, curr.cnt + 1, curr.k - 1));
                    }
                }
            }
        }
        return min;
    }
}