import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] pick;
    static boolean[] visited;    // 방문 여부를 체크
    static boolean[] finished;   // 탐색이 끝났는지 체크
    static int cycleCount;       // 팀을 이룬 학생 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            n = Integer.parseInt(br.readLine());
            pick = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            cycleCount = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                pick[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            System.out.println(n - cycleCount);  // 전체 학생 수에서 팀을 이룬 학생 수를 뺌
        }
    }

    static void dfs(int curr) {
        visited[curr] = true;   // 현재 학생을 방문
        int next = pick[curr];  // 다음 학생으로 이동

        if (!visited[next]) {   // 아직 방문하지 않은 학생이면 계속 DFS 진행
            dfs(next);
        } else if (!finished[next]) {  // 이미 방문했지만 아직 탐색이 끝나지 않았다면 사이클 발견
            // 사이클에 속한 학생들 카운트
            for (int temp = next; temp != curr; temp = pick[temp]) {
                cycleCount++;
            }
            cycleCount++;  // 자기 자신도 사이클에 포함
        }

        finished[curr] = true;  // 현재 학생의 탐색이 끝남
    }
}