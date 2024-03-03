import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String s = br.readLine();
            int[] arr = new int[s.length()];
            int[] arrsum = new int[arr.length];
            int person=0;
            for (int i = 0; i < s.length(); i++) {
                arr[i] = s.charAt(i) - '0'; // 0번 인덱스부터 쌓기
                if(i==0) arrsum[i] = arr[i];
                else arrsum[i] = arrsum[i-1] + arr[i];
            }

            for (int i = 0; i < arr.length; i++) {
                if(arrsum[i] < i + 1) {
                    person = Math.max(person, i+1-arrsum[i]);
                }
            }

            System.out.printf("#%d %d\n", tc, person);
        }
    }
}