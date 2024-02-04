import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
        int[] arrW = new int[10];
        int[] arrK = new int[10];

        for(int i = 0; i < 10; i++) {
            arrW[i] = Integer.parseInt(br.readLine().trim());
        }
        for(int i = 0; i < 10; i++) {
            arrK[i] = Integer.parseInt(br.readLine().trim());
        }
        int maxW = 0;
        int maxK = 0;
        // 오름차순 정렬 후 끝에서 3개 합 구하면 됨

        Arrays.sort(arrW);
        Arrays.sort(arrK);
        for(int i = 0; i < 3; i++) {
            maxW += arrW[10 - i-1];
            maxK += arrK[10 - i-1];
        }



        System.out.print(maxW + " ");
        System.out.println(maxK);
    }
}