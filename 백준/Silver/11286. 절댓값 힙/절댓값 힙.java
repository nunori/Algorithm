import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        // 최소 우선순위 큐
        PriorityQueue<Long> pQ = new PriorityQueue<>();
        // 최대 우선순위 큐
        PriorityQueue<Long> pQ2 = new PriorityQueue<>(Collections.reverseOrder());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= N; tc++) {
            long x = Long.parseLong(br.readLine());
            if (x > 0) {
                pQ.offer(x);
            } else if (x < 0) {
                pQ2.offer(x);
            } else if (x == 0) {
                if (pQ.isEmpty() && pQ2.isEmpty()) {
                    System.out.println(0);
                } else if (pQ.size() != 0 && pQ2.size() != 0) {
                        // 양수 중에서 가장 작은 값
                        long max = pQ.peek();
                        // 음수 중에서 가장 큰 값
                        long min = Math.abs(pQ2.peek());
                        if (max < min) {
                            System.out.println(pQ.poll());
                        } else {
                            System.out.println(pQ2.poll());
                        }
                } else if (pQ.size() == 0 && pQ2.size() != 0) {
                        System.out.println(pQ2.poll());
                } else {
                        System.out.println(pQ.poll());
                }

            }
        }

    }
}