import java.util.*;
import java.io.*;
public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    private static class Node {
        private int x;
        private int y;
        private int cnt;
        private int wall;
        public Node(int x, int y, int cnt, int wall) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.wall = wall;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int r = 0; r < N; r++) {
            String s = br.readLine();
            for(int c = 0; c < M; c++) {
                map[r][c] = s.charAt(c) - '0';
            }
        }

        if(N == 1 && M == 1) {
            System.out.println(1);
            System.exit(0);
        }

        visited = new boolean[N][M][2];

        System.out.println(bfs(0, 0));
    }

    static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 1, 0));
//        visited[x][y][0] = true;
//        visited[x][y][1] = true;

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            if(curr.x == N - 1 && curr.y == M - 1) return curr.cnt;
            for(int d = 0; d < 4; d++) {
                int nr = curr.x + dr[d];
                int nc = curr.y + dc[d];

                if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if(map[nr][nc] == 0) {
                        if(!visited[nr][nc][curr.wall]) {
                            queue.offer(new Node(nr, nc, curr.cnt + 1, curr.wall));
                            visited[nr][nc][curr.wall] = true;
                        }
                    } else if(map[nr][nc] == 1) {
                        if(curr.wall == 0 && !visited[nr][nc][1]) {
                            queue.offer(new Node(nr, nc, curr.cnt + 1, 1));
                            visited[nr][nc][1] = true;
                        }
                    }
                }
             }
        }
        return -1;
    }
}