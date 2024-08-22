import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i = 1; i < N; i++) {
            String I = Integer.toString(i);
            int forCheck = i;
            for(int j = 0; j < I.length(); j++) {
                char ch = I.charAt(j);
                forCheck += ch - '0';
            }
            if(forCheck == N) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}