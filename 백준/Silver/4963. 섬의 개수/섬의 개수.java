import java.util.*;
import java.io.*;
public class Main {
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static int h, w, cnt;
    static int[][] map;
    static boolean[][] visited;
    static boolean connected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(h == 0 && w == 0) break;
            map = new int[h][w];
            for(int r = 0; r < h; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < w; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            visited = new boolean[h][w];
            cnt = 0;
            connected = true;
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++){
                    int[] start = new int[] {i, j};
                    if(map[i][j] == 1 && !visited[i][j]) {
                        cnt++;
                        bfs(start);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void bfs(int[] start) {
        visited[start[0]][start[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            if(map[temp[0]][temp[1]] == 1) {
                connected = true;
                for(int d = 0; d < 8; d++) {
                    int nr = temp[0] + dr[d];
                    int nc = temp[1] + dc[d];

                    if(nr >= 0 && nr < h && nc >= 0 && nc < w && !visited[nr][nc] && map[nr][nc] == 1) {
                        queue.add(new int[]{nr, nc});
                        visited[nr][nc] = true;
                        bfs(new int[] {nr, nc});
                    }
                }
            }
        }
    }
}