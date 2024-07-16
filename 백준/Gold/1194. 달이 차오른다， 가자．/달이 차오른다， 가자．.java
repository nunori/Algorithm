import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][64];

        int start_r = 0;
        int start_c = 0;

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == '0') {
                    start_r = i;
                    start_c = j;
                }
            }
        }
        System.out.println(bfs(start_r, start_c));
    }
    public static int bfs(int row, int column) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, column, 0, 0});
        visited[row][column][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cnt = cur[2];
            int key = cur[3];

            for(int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc][key] || map[nr][nc] == '#') continue;

                if(map[nr][nc] == '1') {
                    return cnt + 1;
                }

                if('a' <= map[nr][nc] && map[nr][nc] <= 'f') {
                    int newKey = key | (1 << (map[nr][nc] - 'a'));
                    visited[nr][nc][newKey] = true;
                    queue.offer(new int[]{nr, nc, cnt + 1, newKey});
                } else if('A' <= map[nr][nc] && map[nr][nc] <= 'F') {
                    if((key & (1 << (map[nr][nc] - 'A'))) != 0) {
                        visited[nr][nc][key] = true;
                        queue.offer(new int[]{nr, nc, cnt + 1, key});
                    }
                } else {
                    visited[nr][nc][key] = true;
                    queue.offer(new int[]{nr, nc, cnt + 1, key});
                }
            }
        }
        return -1;
    }
}