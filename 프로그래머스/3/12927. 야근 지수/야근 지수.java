import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int work : works) {
            pq.offer(work);
        }
        
        while (n > 0) {
            if (pq.isEmpty()) break;
            
            int max = pq.poll();
            
            if (max > 0) {
                max--;
                n--;
                pq.offer(max);
            }
        }
        
        long sum = 0;
        while (!pq.isEmpty()) {
            int work = pq.poll();
            sum += (long) work * work;
        }
        
        return sum;
    }
}
