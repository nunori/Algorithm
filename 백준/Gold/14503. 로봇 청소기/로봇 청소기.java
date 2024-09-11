import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N, M, cr, cc, dir, cnt;
    static int[][] map, visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];

        st = new StringTokenizer(br.readLine());

        cr = Integer.parseInt(st.nextToken());
        cc = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                visited[i][j] = tmp;
            }
        }

        cnt = 0;

        while(true) {
            if (isDirty(cr, cc)) {
                cnt++;
            }
            if (isAllClean(cr, cc)) {
                if (!canGoBack(cr, cc)) break;
            }
            else {
                dir = (dir + 3) % 4;
                int nr = cr + dr[dir];
                int nc = cc + dc[dir];
                if (map[nr][nc] == 0 && visited[nr][nc] == 0) {
                    cr = nr;
                    cc = nc;
                }
            }
        }
        System.out.println(cnt);
    }

    static boolean isDirty(int r, int c) {
        if(map[r][c] == 0 && visited[r][c] == 0) {
            visited[r][c] = 2;
            return true;
        }
        return false;
    }

    static boolean isAllClean(int r, int c) {
        for(int d = 0; d < 4; d++) {
            int nr = cr + dr[d];
            int nc = cc + dc[d];

            if(map[nr][nc] == 0 && visited[nr][nc] == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean canGoBack(int r, int c) {
        int nr = cr - dr[dir];
        int nc = cc - dc[dir];
        if(map[nr][nc] == 0) {
            cr = nr;
            cc = nc;
            return true;
        }
        return false;
    }
}