import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // N명의 손님
            int makingtime = Integer.parseInt(st.nextToken()); // 붕어빵 만드는데 걸리는 시간
            int boong = Integer.parseInt(st.nextToken()); // 붕어빵 갯수, time 시간만큼 boong개의 붕어빵 만들 수 있음


            int[] arrive = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arrive[i] = Integer.parseInt(st.nextToken()); // ex) 1, 2
            }

            Arrays.sort(arrive);
            boolean possible = true;

            for(int i = 0; i < N; i++) {
                int time = arrive[i];
                int boongMade = (time / makingtime) * boong;
                if(boongMade < i + 1) {
                    possible = false;
                    break;
                }
            }

            String result = possible ? "Possible" : "Impossible";
            System.out.printf("#%d %s\n", tc, result);
        }
    }
}