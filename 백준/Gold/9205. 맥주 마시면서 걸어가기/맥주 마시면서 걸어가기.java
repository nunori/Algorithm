import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] conv;
    static boolean[] visited;
    static boolean flag;
    static int festX, festY, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int homeX = Integer.parseInt(st.nextToken());
            int homeY = Integer.parseInt(st.nextToken());
            conv = new int[N + 1][2];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                conv[i][0] = Integer.parseInt(st.nextToken());
                conv[i][1] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            festX = Integer.parseInt(st.nextToken());
            festY = Integer.parseInt(st.nextToken());

            conv[N][0] = festX;
            conv[N][1] = festY;

            visited = new boolean[N + 1];
            flag = false;

            dfs(homeX, homeY);

            if (flag)
                System.out.println("happy");
            else
                System.out.println("sad");
        }
    }

    public static void dfs(int x, int y) {
        if (x == festX && y == festY) {
            flag = true;
            return;
        }

        for (int i = 0; i <= N; i++) {
            if (!visited[i] && dist(x, y, conv[i][0], conv[i][1]) <= 1000) {
                visited[i] = true;
                dfs(conv[i][0], conv[i][1]);
            }
        }
    }

    public static int dist(int aX, int aY, int bX, int bY) {
        return Math.abs(aX - bX) + Math.abs(aY - bY);
    }
}