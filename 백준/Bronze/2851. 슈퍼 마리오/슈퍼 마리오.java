import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = 10;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        for(int i = 0; i < N; i++) {
            if(sum + arr[i] > 100) {
                // Compare which is closer to 100, sum or sum + arr[i]
                if(Math.abs(100 - sum) < Math.abs((sum + arr[i]) - 100)) {
                    System.out.println(sum);
                } else {
                    System.out.println(sum + arr[i]);
                }
                return; // Exit after finding the closest sum
            }
            sum += arr[i];
        }

        // If none of the sums exceed 100, print the total sum.
        System.out.println(sum);
    }
}