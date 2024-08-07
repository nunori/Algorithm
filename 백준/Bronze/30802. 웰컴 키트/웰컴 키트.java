import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[6];

        for(int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int t_shirt = 0;
        for(int i : arr) {
            if( i % T == 0) t_shirt += (i / T);
            else t_shirt += (i / T) + 1;
        }

        int pen_bundle = N / P;
        int pen_single = N % P;

        System.out.println(t_shirt);
        System.out.print(pen_bundle + " ");
        System.out.println(pen_single);
    }
}