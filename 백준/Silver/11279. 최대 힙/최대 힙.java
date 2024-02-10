import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Long> pQ = new PriorityQueue<>(Collections.reverseOrder());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= N; tc++) {
            long X = Integer.parseInt(br.readLine());
            if (X > 0) {
                pQ.offer(X);
            } else {
                if (pQ.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pQ.poll());
                }
            }
        }
    }
}