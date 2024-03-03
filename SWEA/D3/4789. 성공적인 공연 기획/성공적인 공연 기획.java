import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String s = br.readLine();
            int[] arr = new int[s.length() + 1];
            for (int i = 1; i <= s.length(); i++) {
                arr[i] = s.charAt(i - 1) - '0';
            }

            int sum = 0;
            int need = 0;

            for (int i = 1; i <= s.length(); i++) {
                if (sum < i - 1) {
                    need += (i - 1) - sum; // 필요한 사람 수 계산
                    sum = i - 1; // 현재 박수 치는 사람의 수를 필요한 수로 업데이트
                }
                sum += arr[i]; // 현재 인덱스에서 박수 치는 사람 추가
            }
            System.out.printf("#%d %d\n", tc, need);
        }
    }
}