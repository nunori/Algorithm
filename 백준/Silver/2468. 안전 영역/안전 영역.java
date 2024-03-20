import java.util.*;
import java.io.*;

public class Main {
	private static int N;
	private static int cnt;
	private static int max_cnt; // 최대 횟수
	private static int max_h; // 최대 높이
	private static int map[][];

	// 델타배열 설정
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		max_h = 0;
		max_cnt = 0;
		
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] > max_h) max_h = map[r][c]; // 최대 높이 정보 저장
			}
		}
		
		// 비 안올 수도 있어서 0부터 시작
		// 다 잠기는 최대 높이까지 반복
		for(int h = 0; h < max_h + 1; h++) {
			visited = new boolean[N][N];
			cnt = 0;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(!visited[r][c] && map[r][c] > h) {
						dfs(r, c, h);
						cnt ++;
					}
				}
			}
			max_cnt = Math.max(max_cnt, cnt);
		}

		System.out.println(max_cnt);
	}

	public static void dfs(int r, int c, int h) {
		visited[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 조건: 영역 내에 있을 때 && 탐색하지 않은 영역일 때 && h보다 높은 곳일 때만 이어서 탐색
			// map[nr][nc]가 h보다 클 때만 안전영역이기 때문에
			// 이 때 재귀로 호출
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] > h) {
				dfs(nr, nc, h);
			}
		}
	}

}