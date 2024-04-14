import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int homeX = Integer.parseInt(st.nextToken());
            int homeY = Integer.parseInt(st.nextToken());
            int[][] conv = new int[N + 1][2];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                conv[i][0] = Integer.parseInt(st.nextToken());
                conv[i][1] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int festX = Integer.parseInt(st.nextToken());
            int festY = Integer.parseInt(st.nextToken());

            conv[N][0] = festX;
            conv[N][1] = festY;

            boolean[] visited = new boolean[N + 1];

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{homeX, homeY});

            int flag = 0;
            while (!queue.isEmpty()) {
                int[] p = queue.poll();
                if (p[0] == festX && p[1] == festY) {
                    flag = 1;
                    break;
                }

                for(int i = 0; i <= N; i++) {
                    int distance = dist(p[0], p[1], conv[i][0], conv[i][1]);
                    if (!visited[i] && distance <= 1000) {
                        queue.offer(new int[]{conv[i][0], conv[i][1]});
                        visited[i] = true;
                    }
                }
            }
            if(flag == 1)
                System.out.println("happy");
            else
                System.out.println("sad");
        }
    }

    public static int dist(int aX, int aY, int bX, int bY) {
        return Math.abs(aX - bX) + Math.abs(aY - bY);
    }
}