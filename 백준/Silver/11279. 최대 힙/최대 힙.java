import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1.equals(o2)) return 0;
                else if(o1 > o2) return -1;
                else return 1;
            }
        });

        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if(!pq.isEmpty()) {
                    System.out.println(pq.poll());
                } else {
                    System.out.println(0);
                }
            }
            else {
                pq.add(x);
            }
        }
    }
}