import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        int[] arrR = new int[N + 2];
        int[] arrC = new int[N + 2];

        for (int tc = 0; tc < N; tc++) {
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            // 가장 큰 가로, 가장 큰 세로 구해서 곱하면 됨
            // maxR, maxC 구하기

            if (tmp == 0) arrR[tc] = Integer.parseInt(st.nextToken());
            else if (tmp == 1) arrC[tc] = Integer.parseInt(st.nextToken());
        }

        arrR[N] = C;
        arrC[N] = R;
        Arrays.sort(arrR);
        Arrays.sort(arrC);


//        System.out.println("arrR : " + Arrays.toString(arrR));
//        System.out.println("arrC : " + Arrays.toString(arrC));
        int maxR = -1;
        int maxC = -1;

        for (int i = 0; i < N + 1; i++) {
            int tmpR = arrR[i + 1] - arrR[i];
            int tmpC = arrC[i + 1] - arrC[i];
            if (tmpR > maxR) maxR = tmpR;
            if (tmpC > maxC) maxC = tmpC;

        }

        int result = maxR * maxC;
        System.out.println(result);


    }
}