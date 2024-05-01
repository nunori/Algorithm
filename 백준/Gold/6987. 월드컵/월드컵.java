import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] results;
    static boolean possible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 4;
        results = new int[6][3];

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                results[i][0] = Integer.parseInt(st.nextToken()); // 승
                results[i][1] = Integer.parseInt(st.nextToken()); // 무
                results[i][2] = Integer.parseInt(st.nextToken()); // 패
            }

            possible = false;
            check(0, 1);
            System.out.print(possible ? "1 " : "0 ");
        }
    }

    static void check(int team1, int team2) {
        if (team2 == 6) {
            team1++;
            team2 = team1 + 1;
        }
        if (team1 == 5) {
            possible = validate();
            return;
        }

        // team1이 승리하고 team2가 패배하는 경우
        if (results[team1][0] > 0 && results[team2][2] > 0) {
            results[team1][0]--;
            results[team2][2]--;
            check(team1, team2 + 1);
            results[team1][0]++;
            results[team2][2]++;
        }

        // team1과 team2가 무승부하는 경우
        if (results[team1][1] > 0 && results[team2][1] > 0) {
            results[team1][1]--;
            results[team2][1]--;
            check(team1, team2 + 1);
            results[team1][1]++;
            results[team2][1]++;
        }

        // team1이 패배하고 team2가 승리하는 경우
        if (results[team1][2] > 0 && results[team2][0] > 0) {
            results[team1][2]--;
            results[team2][0]--;
            check(team1, team2 + 1);
            results[team1][2]++;
            results[team2][0]++;
        }
    }

    static boolean validate() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (results[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}