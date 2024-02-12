import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int idx = 0; idx < N; idx++) {
            arr[idx] = idx + 1;
        }


        for (int cnt = 0; cnt < M; cnt++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if ((j - i) % 2 == 0) {
                int len = (j - i) / 2;
                for (int cnt2 = i; cnt2 < i + len; cnt2++) {
                    int tmp = arr[cnt2 - 1];
                    arr[cnt2 - 1] = arr[j - 1];
                    arr[j - 1] = tmp;
                    j--;
                }
            } else {
                int len = (j - i + 1) / 2;
                for (int cnt2 = i; cnt2 < i + len; cnt2++) {
                    int tmp = arr[cnt2 - 1];
                    arr[cnt2 - 1] = arr[j - 1];
                    arr[j - 1] = tmp;
                    j--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}