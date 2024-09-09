import java.util.*;
import java.io.*;
public class Main {
    static int K, W, H, min;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[] dnr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dnc = {1, 2, 2, 1, -1, -2, -2, -1};

    private static class Node {
        int x;
        int y;
        int cnt;
        int jump;
        public Node(int x, int y, int cnt, int jump) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.jump = jump;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for(int r = 0; r < H; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < W; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;

        min = bfs(0, 0);

        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0, K));
        visited[x][y][K] = true;

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            if(curr.x == H - 1 && curr.y == W - 1) return curr.cnt;
            for(int d = 0; d < 4; d++) {
                int nr = curr.x + dr[d];
                int nc = curr.y + dc[d];

                if(isOk(nr, nc) && !visited[nr][nc][curr.jump] && map[nr][nc] == 0) {
                    visited[nr][nc][curr.jump] = true;
                    queue.add(new Node(nr, nc, curr.cnt + 1, curr.jump));
                }
            }

            if(curr.jump > 0) {
                for(int d = 0; d < 8; d++) {
                    int nr = curr.x + dnr[d];
                    int nc = curr.y + dnc[d];

                    if(isOk(nr, nc) && !visited[nr][nc][curr.jump - 1] && map[nr][nc] == 0) {
                        visited[nr][nc][curr.jump - 1] = true;
                        queue.add(new Node(nr, nc, curr.cnt + 1, curr.jump - 1));
                    }
                }
            }
        }
        return min;
    }

    static boolean isOk(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W;
    }
}